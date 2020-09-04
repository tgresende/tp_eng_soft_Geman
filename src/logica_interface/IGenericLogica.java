package logica_interface;

import java.util.List;

import objetoAcessoDados.genericObjetoAcessoDados;

public interface IGenericLogica <T extends genericObjetoAcessoDados> {
	public List<T> getList();
	public T get();
	public void save();
	public void delete();
}