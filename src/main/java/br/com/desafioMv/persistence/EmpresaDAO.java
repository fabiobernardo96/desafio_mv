package br.com.desafioMv.persistence;

import java.util.List;

import br.com.desafioMv.model.Empresa;

public interface EmpresaDAO {

	public int insert(Empresa empresa);

	public int delete(Empresa empresa);

	public int update(Empresa empresa);

	public Empresa getById(int id);

	public List<Empresa> getByWhere(String where);
	
}