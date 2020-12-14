package br.com.desafioMv.controller.dto;

import java.sql.Timestamp;
import br.com.desafioMv.model.Movimentacao;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovimentacaoDTO {

	private int id;

	private Timestamp data;

	private int valor;

	private int idCliente;

	private int idConta;

	public MovimentacaoDTO(Movimentacao movimentacao) {

		this.id = movimentacao.getId();
		this.data = movimentacao.getData();
		this.valor = movimentacao.getValor();
		this.idCliente = movimentacao.getIdCliente();
		this.idConta = movimentacao.getIdConta();

	}
}
