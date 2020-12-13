package br.com.desafioMv.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Empresa implements Serializable {

	private int id;

	private int saldo;

	private String nome;	
	
}