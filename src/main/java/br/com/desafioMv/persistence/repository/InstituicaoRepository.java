package br.com.desafioMv.persistence.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.desafioMv.model.Instituicao;
import br.com.desafioMv.persistence.InstituicaoDAO;

@Repository
public class InstituicaoRepository implements InstituicaoDAO {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public int insert(Instituicao instituicao) {

		String sql = "INSERT INTO INSTITUICAO (NOME) VALUES (?)";

		return jdbc.update(sql, instituicao.getNome());

	}

	@Override
	public int delete(Instituicao instituicao) {

		String sql = "DELETE FROM INSTITUICAO WHERE ID = ?";

		return jdbc.update(sql, instituicao.getId() );

	}

	@Override
	public int update(Instituicao instituicao) {

		String sql = "UPDATE INSTITUICAO SET NOME = ? WHERE ID = ?";

		return jdbc.update(sql, instituicao.getNome(), instituicao.getId());

	}

	@Override
	public Instituicao getById(int id) {

		String sql = "SELECT * FROM INSTITUICAO WHERE ID = ?";

		return jdbc.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<Instituicao>(Instituicao.class));
	}

	@Override
	public List<Instituicao> getByWhere(String where) {

		String sql = "SELECT * FROM INSTITUICAO WHERE 1 " + where;

		return jdbc.query(sql, new BeanPropertyRowMapper<Instituicao>(Instituicao.class));

	}
	
}
