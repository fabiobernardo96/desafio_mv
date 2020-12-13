package br.com.desafioMv.controller.dto;

import br.com.desafioMv.model.Conta;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContaDTO {

	private int id;

	private String nome;

	private int saldo;

	private int idCliente;

	public ContaDTO(Conta conta) {

		this.id = conta.getId();
		this.nome = conta.getNome();
		this.saldo = conta.getSaldo();
		this.idCliente = conta.getIdCliente();

	}

}
