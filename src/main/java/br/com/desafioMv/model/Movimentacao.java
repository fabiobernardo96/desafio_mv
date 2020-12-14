package br.com.desafioMv.model;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@RequiredArgsConstructor
public class Movimentacao implements Serializable {
 
	private int id;

	private Timestamp data;

	private int idConta;
	
	private int valor;

	private int tipo;
}