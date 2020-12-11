package br.com.desafiomv.controller.dto;

import br.com.desafioMv.model.Cliente;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO {
	
	private int id;
	
	private String nome;
	
	private String email;
	
	private int telefone;
	
	private String cpf_cnpj;
	
	public ClienteDTO(Cliente cliente) {

		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.email = cliente.getEmail();
		this.telefone = cliente.getTelefone();
		this.cpf_cnpj = cliente.getCpfCpnj();

	}

}
