package br.com.desafioMv.model;

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

	private long telefone;

	private long cpfCnpj;

}