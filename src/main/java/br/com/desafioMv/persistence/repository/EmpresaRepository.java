package br.com.desafioMv.persistence.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.desafioMv.model.Empresa;
import br.com.desafioMv.persistence.EmpresaDAO;

@Repository
public class EmpresaRepository implements EmpresaDAO {

	@Autowired
	private JdbcTemplate jdbc;

	@Override
	public int insert(Empresa empresa) {

		String sql = "INSERT INTO EMPRESA (ID, NOME, SALDO) VALUES (seq_empresa.nextval, ?, ?)";

		return jdbc.update(sql, empresa.getNome(), empresa.getSaldo() );

	}

	@Override
	public int delete(Empresa empresa) {

		String sql = "DELETE FROM EMPRESA WHERE ID = ?";

		return jdbc.update(sql, empresa.getId());

	}

	@Override
	public int update(Empresa empresa) {

		String sql = "UPDATE EMPRESA SET SALDO = ? WHERE ID = ?";

		return jdbc.update(sql, empresa.getSaldo() );

	}

	@Override
	public Empresa getById(int id) {

		String sql = "SELECT * FROM EMPRESA WHERE ID = ?";

		return jdbc.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<Empresa>(Empresa.class));

	}

	@Override
	public List<Empresa> getByWhere(String where) {

		String sql = "SELECT * FROM EMPRESA WHERE 1 " + where;

		return jdbc.query(sql, new BeanPropertyRowMapper<Empresa>(Empresa.class));

	}
	
}
