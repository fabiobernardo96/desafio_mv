package br.com.desafioMv.persistence.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.desafioMv.model.Endereco;
import br.com.desafioMv.persistence.EnderecoDAO;

@Repository
public class EnderecoRepository implements EnderecoDAO {

	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public int insert(Endereco endereco) {

		String sql = "INSERT INTO ENDERECO (ID, RUA, NUMERO, BAIRRO, CIDADE, ESTADO, PAIS, CEP, ID_CLIENTE) VALUES (seq_endereco.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";

		return jdbc.update(sql,
							endereco.getRua(), endereco.getNumero(), endereco.getBairro(), endereco.getCidade(),
						endereco.getEstado(), endereco.getPais(), endereco.getCep(), endereco.getIdCliente() );

	}

	@Override
	public int delete(Endereco endereco) {

		String sql = "DELETE FROM ENDERECO WHERE ID = ?";

		return jdbc.update(sql, endereco.getId() );

	}

	@Override
	public int update(Endereco endereco) {

		String sql = "UPDATE ENDERECO SET RUA = ?, NUMERO = ?, BAIRRO = ?, CIDADE = ?, ESTADO = ?, PAIS = ?, CEP = ? WHERE ID = ?";

		return jdbc.update(sql,
							endereco.getRua(), endereco.getNumero(), endereco.getBairro(), endereco.getCidade(),
						endereco.getEstado(), endereco.getPais(), endereco.getCep() );

	}

	@Override
	public Endereco getById(int id) {

		String sql = "SELECT * FROM ENDERECO WHERE ID = ?";

		return jdbc.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<Endereco>(Endereco.class));

	}

	@Override
	public List<Endereco> getByWhere(String where) {

		String sql = "SELECT * FROM ENDERECO WHERE 1 " + where;

		return jdbc.query(sql, new BeanPropertyRowMapper<Endereco>(Endereco.class));

	}

	
}
