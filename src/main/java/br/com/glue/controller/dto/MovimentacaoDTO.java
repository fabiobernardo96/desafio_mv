package br.com.desafiomv.controller.dto;

import java.sql.Timestamp;
import br.com.desafioMv.model.Movimentacao;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovimentacaoDTO {

	private int id;

	private Timestamp data;

	private int id_cliente;

	private int id_conta;

	public MovimentacaoDTO(Movimentacao movimentacao) {

		this.id = movimentacao.getId();
		this.data = movimentacao.getData();
		this.id_cliente = movimentacao.getIdCliente();
		this.id_conta = movimentacao.getIdConta();

	}
}
