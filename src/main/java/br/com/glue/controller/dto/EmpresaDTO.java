package br.com.desafiomv.controller.dto;

import br.com.desafioMv.model.Empresa;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpresaDTO {
	
	private int id;
	
	private int saldo;

	private String nome;
	
	public EmpresaDTO(Empresa empresa) {

		this.id = empresa.getId();
		this.saldo = empresa.getSaldo();
		this.nome = empresa.getNome();

	}

}
