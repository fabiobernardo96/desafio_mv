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

		String sql = "INSERT INTO CONTA (ID, NUMERO, SALDO, ID_CLIENTE, ACTIVE, ID_INSTITUICAO) VALUES (seq_conta.nextval, ?, ?, ?, ?, ?)";

		return jdbc.update(sql, conta.getNumero(), conta.getSaldo(), conta.getIdCliente(), conta.getActive(), conta.getIdInstituicao() );

	}

	@Override
	public int delete(Conta conta) {
		
		String sql = "UPDATE FROM CONTA SET ACTIVE = 'N' WHERE ID = ?";

		return jdbc.update(sql, conta.getId());

	}

	@Override
	public int update(Conta conta) {

		String sql = "UPDATE CONTA SET SALDO = ? WHERE ID = ?";

		return jdbc.update(sql, conta.getSaldo());

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
