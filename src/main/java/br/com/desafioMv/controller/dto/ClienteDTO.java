package br.com.desafioMv.controller.dto;

import br.com.desafioMv.model.Cliente;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO {
	
	private int id;
	
	private String nome;
	
	private String email;
	
	private String telefone;
	
	private String cpfCnpj;
	
	public ClienteDTO(Cliente cliente) {

		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.email = cliente.getEmail();
		this.telefone = cliente.getTelefone();
		this.cpfCnpj = cliente.getCpfCnpj();

	}

}
