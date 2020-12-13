 package br.com.desafioMv.persistence.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.desafioMv.model.Conta;
import br.com.desafioMv.persistence.ContaDAO;

@Repository
public class ContaRepository implements ContaDAO {

	@Autowired
	private JdbcTemplate jdbc;

	@Override
	public int insert(Conta conta) {

		String sql = "INSERT INTO CONTA (NOME, SALDO, ID_CLIENTE) VALUES (?, ?, ?)";

		return jdbc.update(sql, conta.getNome(), conta.getSaldo(), conta.getIdCliente());

	}

	@Override
	public int delete(Conta conta) {

		String sql = "DELETE FROM CONTA WHERE ID = ?";

		return jdbc.update(sql, conta.getId());

	}

	@Override
	public int update(Conta conta) {

		String sql = "UPDATE CONTA SET NOME = ?, SALDO = ? WHERE ID = ?";

		return jdbc.update(sql, conta.getNome(), conta.getSaldo());

	}

	@Override
	public Conta getById(int id) {

		String sql = "SELECT * FROM CONTA WHERE ID = ?";

		return jdbc.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<Conta>(Conta.class));

	}

	@Override
	public List<Conta> getByWhere(String where) {

		String sql = "SELECT * FROM CONTA WHERE 1 " + where;

		return jdbc.query(sql, new BeanPropertyRowMapper<Conta>(Conta.class));

	}

}
