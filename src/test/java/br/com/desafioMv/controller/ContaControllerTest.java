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

import br.com.desafioMv.model.Conta;
import br.com.desafioMv.model.Movimentacao;
import br.com.desafioMv.persistence.repository.ContaRepository;
import br.com.desafioMv.persistence.repository.MovimentacaoRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@AutoConfigureMockMvc
public class ContaControllerTest {

	@Autowired
	private ContaRepository contaCrud;
	private static Conta conta = new Conta();
	
	@Autowired
	private MovimentacaoRepository movimentacaoCrud;	
	private static Movimentacao movimentacao = new Movimentacao();

	@BeforeAll
	public static void setUp() {

		conta = new Conta();
		conta.setNumero("12345678");
		conta.setSaldo(5000);
		conta.setIdCliente(66);
		conta.setActive("Y");
		conta.setIdInstituicao(11);
		
	}

	//@Test
	public void testInsert() {

		try {

			int insertConta = contaCrud.insert(conta);
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}
	
	//@Test
	public void testUpdate() {
		
		try {
			
			conta.setId(2);
			conta.setSaldo(5000);
				
			long updateConta = contaCrud.update(conta);
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
	}
	
	//@Test
	public void testGetById() {
		
		try {
			
			Conta getConta = contaCrud.getById(29);
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
	}
	
	//@Test
	public void testgetByWhere() {
		
		try {
			
			List<Conta> listConta = contaCrud.getByWhere("AND ACTIVE = 'Y'");
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
	}
	
	@Test
	public void testDelete() {
				
		try {
			
			conta.setId(29);
			
			int deleteConta = contaCrud.delete(conta);
			
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
