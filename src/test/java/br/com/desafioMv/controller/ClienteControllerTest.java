package br.com.desafioMv.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.desafioMv.model.Cliente;
import br.com.desafioMv.model.Endereco;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ClienteControllerTest {

	@Autowired
	private MockMvc mockMvc;

	private static Cliente cliente = new Cliente();

	@BeforeAll
	public static void setUp() {

		cliente = new Cliente();
		cliente.setNome("Fabio Bernardo");
		cliente.setEmail("fabio.bernardo96@gmail.com");
		cliente.setTelefone("5581998815345");
		cliente.setCpfCnpj("11363879420");
		
		Endereco endereco = new Endereco();
		endereco.setNumero(155);
		endereco.setRua("rua");
		endereco.setBairro("bairro");
		endereco.setCidade("cidade");
		endereco.setEstado("estado");
		endereco.setPais("pais");
		endereco.setCep(12314556);
		
		cliente.getEnderecos().add(endereco);
	}

	@Test
	public void testInsert() {

		try {

			this.mockMvc.perform(post("/cliente/insert").content(asJsonString(cliente))
					.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));

		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}
	
	@Test
	public void testUpdate() {

		try {

			this.mockMvc.perform(put("/cliente/update").content(asJsonString(cliente))
					.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));

		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}
	
	@Test
	public void testGetByWhere() {

		try {

			this.mockMvc.perform(post("/cliente/").content(asJsonString(cliente))
					.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));

		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}


	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
