package br.com.desafioMv.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

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
		cliente.setTelefone(5581998815345L);
		cliente.setCpfCnpj(11363879420L);
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

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
