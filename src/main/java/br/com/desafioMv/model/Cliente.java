package br.com.desafioMv.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Cliente implements Serializable {

	private long id;

	private String nome;

	private String email;

	private String telefone;

	private String cpfCnpj;
	
	private List<Endereco> enderecos = new ArrayList<Endereco>();
}