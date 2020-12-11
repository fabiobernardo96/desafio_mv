package br.com.desafiomv.controller.dto;

import br.com.desafioMv.model.Endereco;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoDTO {
	
	private int id;

	private String rua;

	private int numero;

	private String bairro;
 
	private String cidade;

	private String estado;
	
	private String pais;
	
	private int cep;

	private int id_cliente;
	
	public EnderecoDTO(Endereco endereco) {

		this.id = endereco.getId();
		this.rua = endereco.getRua();
		this.numero = endereco.getNumero();
		this.bairro = endereco.getBairro();
		this.cidade = endereco.getCidade();
		this.estado = endereco.getEstado();
		this.pais = endereco.getPais();
		this.cep = endereco.getCep();
		this.id_cliente = endereco.getIdCliente();

	}

}
