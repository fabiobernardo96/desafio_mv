package br.com.desafioMv.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@RequiredArgsConstructor
public class Instituicao implements Serializable {

	private int id;

	private String nome;
	
}