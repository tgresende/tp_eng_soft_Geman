package businessInterface;

import java.util.List;


public interface IGenericBusiness <T extends genericDataAccessObject.GenericDataAccessObject> {
	public List<T> getList();
	public T get(int id);
	public boolean save(T obj);
	public void delete(int id);
}