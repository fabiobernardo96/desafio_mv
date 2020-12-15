package br.com.desafioMv.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Endereco implements Serializable {

	private int id;

	private String rua;

	private int numero;

	private String bairro;

	private String cidade;

	private String estado;

	private String pais;

	private int cep;

	private long idCliente;	
		
}
