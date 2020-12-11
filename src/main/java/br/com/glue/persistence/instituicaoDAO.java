package br.com.desafioMv.persistence;

import java.util.List;
import br.com.desafioMv.model.Tag;

public interface TagDAO {

	public int insert(Tag tag);

	public int delete(Tag tag);

	public int update(Tag tag);

	public Tag getById(int idTag);

	public List<Tag> getByWhere(String where);

}
