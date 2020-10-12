package dataInterface;

import java.util.List;

import genericDataAccessObject.GenericDataAccessObject;


public interface IGenericDados <T extends GenericDataAccessObject> {
	public List<T> getList();
	public T get(int id);
	public void save();
	public void delete(int id);
}
