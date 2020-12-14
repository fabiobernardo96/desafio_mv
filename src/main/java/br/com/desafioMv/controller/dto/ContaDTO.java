package br.com.desafioMv.controller.dto;

import br.com.desafioMv.model.Conta;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContaDTO {

	private int id;

	private String numero;

	private int saldo;

	private int idCliente;

	private String active;

	private int idInstituicao;

	public ContaDTO(Conta conta) {

		this.id = conta.getId();
		this.numero = conta.getNumero();
		this.saldo = conta.getSaldo();
		this.idCliente = conta.getIdCliente();
		this.active = conta.getActive();
		this.idInstituicao = conta.getIdInstituicao();

	}

}
