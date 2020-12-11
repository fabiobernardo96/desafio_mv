package br.com.desafiomv.persistence;

import java.util.List;
import br.com.desafioMv.model.Conta;

public interface ContaDAO {
	
	public int insert(Conta conta);

	public int delete(Conta conta);

	public int update(Conta conta);

	public Conta getById(int idConta);

	public  List<Conta> getByWhere(String where);

}
