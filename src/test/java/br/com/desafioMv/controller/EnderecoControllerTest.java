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

import br.com.desafioMv.model.Endereco;
import br.com.desafioMv.persistence.repository.EnderecoRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@AutoConfigureMockMvc
public class EnderecoControllerTest {

	@Autowired
	private EnderecoRepository enderecoCrud;

	private static Endereco endereco = new Endereco();

	@BeforeAll
	public static void setUp() {
	
		Endereco endereco = new Endereco();
		

	}
	
	//@Test
	public void testUpdate() {
		
		try {
			
			endereco.setId(46);
			endereco.setNumero("155");
			endereco.setRua("Das Rosas");
			endereco.setBairro("Imbiribeira");
				
			int updateEndereco = enderecoCrud.update(endereco);
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
	}
	
	//@Test
	public void testGetById() {
		
		try {
			
			Endereco getEndereco = enderecoCrud.getById(29);
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
	}
	
	//@Test
	public void testgetByWhere() {
		
		try {
			
			List<Endereco> listEndereco = enderecoCrud.getByWhere("");
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
	}
	
	@Test
	public void testDelete() {
				
		try {
			
			endereco.setId(46);
			
			int deleteEndereco = enderecoCrud.delete(endereco);
			
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
