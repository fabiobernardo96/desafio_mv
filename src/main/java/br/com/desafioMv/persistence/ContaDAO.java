package br.com.desafioMv.persistence;

import java.util.List;

import br.com.desafioMv.model.Conta;

public interface ContaDAO {
	
	public int insert(Conta conta);
		
	public int delete(Conta conta);

	public int update(Conta conta);

	public Conta getById(int id);

	public  List<Conta> getByWhere(String where);


}
