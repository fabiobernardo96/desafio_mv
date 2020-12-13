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

import br.com.desafioMv.persistence.repository.MovimentacaoRepository;
import br.com.desafioMv.controller.dto.MovimentacaoDTO;
import br.com.desafioMv.model.Movimentacao;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/movimentacao")
@RequiredArgsConstructor
public class MovimentacaoController {
	
	@Autowired
	private final MovimentacaoRepository repository;
	
	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<MovimentacaoDTO> getById(@PathVariable int id) {

		var object = this.repository.getById(id);

		return new ResponseEntity<MovimentacaoDTO>(new MovimentacaoDTO(object), HttpStatus.OK);
	}
	
	@PostMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<MovimentacaoDTO>> getByWhere(@RequestBody String where) {

		var list = this.repository.getByWhere(where);

		var dtos = list.stream().map(MovimentacaoDTO::new).collect(Collectors.toList());

		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	@PostMapping(value = "/insert")
	public ResponseEntity<MovimentacaoDTO> post(@RequestBody Movimentacao movimentacao) {

		repository.insert(movimentacao);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping(value = "/update")
	public ResponseEntity<MovimentacaoDTO> put(@RequestBody Movimentacao movimentacao) {

		repository.update(movimentacao);

		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<MovimentacaoDTO> delete(@PathVariable int id) {

		var optional = Optional.ofNullable(repository.getById(id));

		if (optional.isPresent()) {
			repository.delete(optional.get());

			return new ResponseEntity<>(HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}

}
