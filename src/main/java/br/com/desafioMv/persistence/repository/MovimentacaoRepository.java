package br.com.desafioMv.persistence.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.desafioMv.model.Movimentacao;
import br.com.desafioMv.persistence.MovimentacaoDAO;

@Repository
public class MovimentacaoRepository implements MovimentacaoDAO {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public int insert(Movimentacao movimentacao) {

		String sql = "INSERT INTO MOVIMENTACAO (ID, DATA, ID_CONTA, VALOR, TIPO) VALUES (seq_movimentacao.nextval, SYSDATE, ?, ?, ?)";

		return jdbc.update(sql, movimentacao.getData(), movimentacao.getIdConta(),  movimentacao.getValor(), movimentacao.getTipo() );

	}

	@Override
	public int delete(Movimentacao movimentacao) {

		String sql = "DELETE FROM MOVIMENTACAO WHERE ID = ?";

		return jdbc.update(sql, movimentacao.getId() );

	}

	@Override
	public int update(Movimentacao movimentacao) {

		String sql = "UPDATE MOVIMENTACAO SET DATA = ?, VALOR = ?, TIPO = ? WHERE ID = ?";

		return jdbc.update(sql, movimentacao.getData(), movimentacao.getValor(), movimentacao.getTipo(), movimentacao.getId() );

	}

	@Override
	public Movimentacao getById(int id) {

		String sql = "SELECT * FROM MOVIMENTACAO WHERE ID = ?";

		return jdbc.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<Movimentacao>(Movimentacao.class));
	}

	@Override
	public List<Movimentacao> getByWhere(String where) {

		String sql = "SELECT * FROM MOVIMENTACAO WHERE 1 " + where;

		return jdbc.query(sql, new BeanPropertyRowMapper<Movimentacao>(Movimentacao.class));

	}
	
}
