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

import br.com.desafioMv.controller.dto.ClienteDTO;
import br.com.desafioMv.model.Cliente;
import br.com.desafioMv.persistence.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteController {
	
	@Autowired
	private final ClienteRepository repository;
	
	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ClienteDTO> getById(@PathVariable int id) {

		var object = this.repository.getById(id);

		return new ResponseEntity<ClienteDTO>(new ClienteDTO(object), HttpStatus.OK);
	}
	
	@PostMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<ClienteDTO>> getByWhere(@RequestBody String where) {

		var list = this.repository.getByWhere(where);

		var dtos = list.stream().map(ClienteDTO::new).collect(Collectors.toList());

		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	@PostMapping(value = "/insert",  consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ClienteDTO> post(@RequestBody Cliente cliente) {

		repository.insert(cliente);

		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping(value = "/update/",  consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ClienteDTO> put(@RequestBody Cliente cliente) {

		repository.update(cliente);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<ClienteDTO> delete(@PathVariable int id) {

		var optional = Optional.ofNullable(repository.getById(id));

		if (optional.isPresent()) {
			repository.delete(optional.get());

			return new ResponseEntity<>(HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}

}
