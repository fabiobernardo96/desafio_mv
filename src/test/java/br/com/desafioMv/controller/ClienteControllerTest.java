package br.com.desafioMv.controller;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.desafioMv.model.Cliente;
import br.com.desafioMv.model.Endereco;
import br.com.desafioMv.persistence.repository.ClienteRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@AutoConfigureMockMvc
public class ClienteControllerTest {

	@Autowired
	private ClienteRepository clienteCrud;

	private static Cliente cliente = new Cliente();

	@BeforeAll
	public static void setUp() {

		cliente = new Cliente();
		cliente.setNome("Fabio Bernardo");
		cliente.setEmail("fabio.bernardo96@gmail.com");
		cliente.setTelefone("5581998815345");
		cliente.setCpfCnpj("11363879420");
		
		Endereco endereco = new Endereco();
		endereco.setNumero("155");
		endereco.setRua("Das Rosas");
		endereco.setBairro("Imbiribeira");
		endereco.setCidade("Recife");
		endereco.setEstado("PE");
		endereco.setPais("Brasil");
		endereco.setCep("53300260");
		
		cliente.getEnderecos().add(endereco);
	}

	//@Test
	public void testInsert() {

		try {

			long insertCliente = clienteCrud.insert(cliente);
			
			cliente.setId(insertCliente);
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}
	
	//@Test
	public void testUpdate() {
		
		try {
			
			cliente.setNome("Fabio Silva");
			cliente.setEmail("fabio.silva@gmail.com");
				
			long updateCliente = clienteCrud.update(cliente);
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
	}
	
	@Test
	public void testGetById() {
		
		try {
			
			Cliente getCliente = clienteCrud.getById(29);
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
	}
	
	//@Test
	public void testgetByWhere() {
		
		try {
			
			List<Cliente> listCliente = clienteCrud.getByWhere("AND NOME = 'Fabio Silva'");
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
	}
	
	//@Test
	public void testDelete() {
				
		try {
			
			cliente.setId(29);
			
			int deleteCliente = clienteCrud.delete(cliente);
			
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
