package br.com.desafioMv.persistence.repository;

import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import br.com.desafioMv.model.Cliente;
import br.com.desafioMv.model.Endereco;
import br.com.desafioMv.persistence.ClienteDAO;

@Repository
public class ClienteRepository implements ClienteDAO {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private JdbcTemplate jdbc;

	@Override
	public long insert(Cliente cliente) {
	    String insertSql = "INSERT INTO CLIENTE (ID, NOME, EMAIL, TELEFONE, CPF_CNPJ) VALUES (seq_cliente.nextval, ?, ?, ?, ?)";
	    KeyHolder keyHolder = new GeneratedKeyHolder();
	    jdbc.update(connection -> {
	      PreparedStatement ps = connection.prepareStatement(insertSql, new String[] { "ID" });
	        ps.setString(1,	cliente.getNome() );
	        ps.setString(2, cliente.getEmail() );
	        ps.setString(3,	cliente.getTelefone() );
	        ps.setString(4, cliente.getCpfCnpj() );
	      return ps;
	    }, keyHolder);
	    
		for(Endereco endereco: cliente.getEnderecos()) {
			endereco.setIdCliente(keyHolder.getKey().longValue());
			enderecoRepository.insert(endereco);
		}
		
	    return keyHolder.getKey().longValue();
	  }

	@Override
	public int delete(Cliente cliente) {

		String sql = "DELETE FROM CLIENTE WHERE ID = ?";
		
		return jdbc.update(sql, cliente.getId() );

	}

	@Override
	public int update(Cliente cliente) {

		String sql = "UPDATE CLIENTE SET NOME = ?, EMAIL = ?, TELEFONE = ? WHERE ID = ?";
		
		return jdbc.update(sql, cliente.getNome(), cliente.getEmail(), cliente.getTelefone(), cliente.getId() );
		
	}
	
	
	@Override
	public Cliente getById(int id) {

		String sql = "SELECT * FROM CLIENTE WHERE ID = ?";
		
		return jdbc.queryForObject(sql, new Object[] { id },
				new BeanPropertyRowMapper<Cliente>(Cliente.class));

	}

	@Override
	public List<Cliente> getByWhere(String where) {

		String sql = "SELECT * FROM CLIENTE WHERE 1 = 1 " + where;
		
		return jdbc.query(sql, new BeanPropertyRowMapper<Cliente>(Cliente.class));


	}
	
}
