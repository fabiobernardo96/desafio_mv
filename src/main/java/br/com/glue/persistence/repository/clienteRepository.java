package br.com.desafioMv.persistence.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.desafioMv.model.Cliente;
import br.com.desafioMv.persistence.ClienteDAO;

@Repository
public class ClienteRepository implements ClienteDAO {

	@Autowired
	private JdbcTemplate jdbc;

	@Override
	public int insert(Cliente cliente) {

		String sql = "INSERT INTO CLIENTE (NOME, EMAIL, TELEFONE, CPF_CNPJ) VALUES (?, ?, ?, ?)";
		
		return jdbc.update(sql, cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getTelefone(), cliente.getCpfCnpj() );
	}

	@Override
	public int delete(Cliente cliente) {

		String sql = "DELETE FROM CLIENTE WHERE ID = ?";
		
		
		return jdbc.update(sql, cliente.getId() );

	}

	@Override
	public int update(Cliente cliente) {

		String sql = "UPDATE CLIENTE SET NOME = ?, EMAIL = ?, TELEFONE = ?, CPF_CNOJ = ? WHERE ID = ?";
		
		
		return jdbc.update(sql, cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getTelefone(), cliente.getCpfCnpj() );
		
	}
	
	
	@Override
	public Cliente getById(int idCliente) {

		String sql = "SELECT * FROM CLIENTE WHERE ID = ?";
		
		
		return jdbc.queryForObject(sql, new Object[] { idCliente },
				new BeanPropertyRowMapper<Cliente>(Cliente.class));

	}

	@Override
	public List<Cliente> getByWhere(String where) {

		String sql = "SELECT * FROM CLIENTE WHERE 1 " + where;
		
		return jdbc.query(sql, new BeanPropertyRowMapper<Cliente>(Cliente.class));


	}
	
}
