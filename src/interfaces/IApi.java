package interfaces;

import java.util.ArrayList;

public interface IApi<T> {

	public ArrayList<T> getAll();

	public T add(T t);

	public T update(T t);

	public boolean delete(T t);
}
