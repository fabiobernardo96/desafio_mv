package br.com.desafiomv.persistence;

import java.util.List;
import br.com.desafioMv.model.Cliente;

public interface ClienteDAO {
	
	public int insert(Cliente cliente);

	public int delete(Cliente cliente);

	public int update(Cliente cliente);

	public Cliente getById(int idCliente);

	public List<Cliente> getByWhere(String where);
		
}
