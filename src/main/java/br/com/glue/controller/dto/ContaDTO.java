package br.com.desafiomv.controller.dto;

import br.com.desafioMv.model.Conta;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContaDTO {

	private int id;

	private String nome;

	private int saldo;

	private int id_cliente;

	public ContaDTO(Conta conta) {

		this.id = conta.getId();
		this.nome = conta.getNome();
		this.saldo = conta.getSaldo();
		this.id_cliente = conta.getIdCliente();

	}

}
