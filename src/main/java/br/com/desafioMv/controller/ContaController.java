package br.com.desafioMv.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafioMv.controller.dto.ContaDTO;
import br.com.desafioMv.model.Conta;
import br.com.desafioMv.persistence.repository.ContaRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/conta")
@RequiredArgsConstructor
public class ContaController {

	@Autowired
	private final ContaRepository repository;

	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ContaDTO> getById(@PathVariable int id) {

		var object = this.repository.getById(id);

		return new ResponseEntity<ContaDTO>(new ContaDTO(object), HttpStatus.OK);
	}

	@PostMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<ContaDTO>> getByWhere(@RequestBody String where) {

		var list = this.repository.getByWhere(where);

		var dtos = list.stream().map(ContaDTO::new).collect(Collectors.toList());

		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}

	@PostMapping(value = "/insert",  consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ContaDTO> post(@RequestBody Conta conta) {

		repository.insert(conta);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping(value = "/update",  consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ContaDTO> put(@RequestBody Conta conta) {

		repository.update(conta);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<ContaDTO> delete(@PathVariable int id) {

		var optional = Optional.ofNullable(repository.getById(id));

		if (optional.isPresent()) {
			repository.delete(optional.get());

			return new ResponseEntity<>(HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}

}
