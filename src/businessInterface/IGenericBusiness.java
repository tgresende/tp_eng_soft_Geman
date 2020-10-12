package businessInterface;

import java.util.List;

import dataAccessObject.GenericDataAccessObject;

public interface IGenericBusiness <T extends GenericDataAccessObject> {
	public List<T> getList();
	public T get(int id);
	public void save();
	public void delete(int id);
}