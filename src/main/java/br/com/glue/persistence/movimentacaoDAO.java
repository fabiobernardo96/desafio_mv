package br.com.desafiomv.persistence;

import java.util.List;
import br.com.desafioMv.model.Movimentacao;

public interface MovimentacaoDAO {
	
	public int insert(Movimentacao movimentacao);

	public int delete(Movimentacao movimentacao);

	public int update(Movimentacao movimentacao);

	public Movimentacao getById(int idMovimentacao);

	public List<Movimentacao> getByWhere(String where);
		
}
