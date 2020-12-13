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

import br.com.desafioMv.persistence.repository.EnderecoRepository;
import br.com.desafioMv.controller.dto.EnderecoDTO;
import br.com.desafioMv.model.Endereco;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/endereco")
@RequiredArgsConstructor
public class EnderecoController {
	
	@Autowired
	private final EnderecoRepository repository;
	
	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<EnderecoDTO> getById(@PathVariable int id) {

		var object = this.repository.getById(id);

		return new ResponseEntity<EnderecoDTO>(new EnderecoDTO(object), HttpStatus.OK);
	}
	
	@PostMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<EnderecoDTO>> getByWhere(@RequestBody String where) {

		var list = this.repository.getByWhere(where);

		var dtos = list.stream().map(EnderecoDTO::new).collect(Collectors.toList());

		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	@PostMapping(value = "/insert",  consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<EnderecoDTO> post(@RequestBody Endereco endereco) {

		repository.insert(endereco);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping(value = "/update",  consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<EnderecoDTO> put(@RequestBody Endereco endereco) {

		repository.update(endereco);

		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<EnderecoDTO> delete(@PathVariable int id) {

		var optional = Optional.ofNullable(repository.getById(id));

		if (optional.isPresent()) {
			repository.delete(optional.get());

			return new ResponseEntity<>(HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}

}
