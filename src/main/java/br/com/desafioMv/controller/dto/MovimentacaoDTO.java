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

	private int idConta;

	private int valor;

	private int tipo;

	public MovimentacaoDTO(Movimentacao movimentacao) {

		this.id = movimentacao.getId();
		this.data = movimentacao.getData();
		this.idConta = movimentacao.getIdConta();
		this.valor = movimentacao.getValor();
		this.tipo = movimentacao.getTipo();

	}
}
