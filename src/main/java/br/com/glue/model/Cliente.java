package br.com.desafiomv.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Cliente implements Serializable {

	private int id;

	private String nome;

	private String email;

	private int telefone;

	private int cpf_cnpj;

}