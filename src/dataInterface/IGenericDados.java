package dataInterface;

import java.util.List;

import dataAccessObject.genericObjetoAcessoDados;

public interface IGenericDados <T extends genericObjetoAcessoDados> {
	public List<T> getList();
	public T get(int id);
	public void save();
	public void delete(int id);
}
