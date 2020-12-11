package br.com.desafiomv.persistence;

import java.util.List;
import br.com.desafioMv.model.Endereco;

public interface EnderecoDAO {
	
	public int insert(Endereco endereco);

	public int delete(Endereco endereco);

	public int update(Endereco endereco);

	public Endereco getById(int idEndereco);

	public  List<Endereco> getByWhere(String where);

		
}
