package businessInterface;

import java.util.List;


public interface IGenericBusiness <T extends genericDataAccessObject.GenericDataAccessObject> {
	public List<T> getList();
	public T get(int id);
	public void save();
	public void delete(int id);
}