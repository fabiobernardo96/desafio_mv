package br.com.desafioMv.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Conta implements Serializable {

	private int id;

	private String nome;

	private int saldo;

	private int idCliente;
		
}