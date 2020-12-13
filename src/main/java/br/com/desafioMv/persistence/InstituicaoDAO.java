package br.com.desafioMv.persistence;

import java.util.List;

import br.com.desafioMv.model.Instituicao;

public interface InstituicaoDAO {

	public int insert(Instituicao instituaicao);

	public int delete(Instituicao instituaicao);

	public int update(Instituicao instituaicao);

	public Instituicao getById(int id);

	public List<Instituicao> getByWhere(String where);

}
