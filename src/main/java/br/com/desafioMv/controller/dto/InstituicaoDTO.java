package br.com.desafioMv.controller.dto;

import br.com.desafioMv.model.Instituicao;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InstituicaoDTO {

	private int id;

	private String nome;

	public InstituicaoDTO(Instituicao instituicao) {

		this.id = instituicao.getId();
		this.nome = instituicao.getNome();

	}
}
