package interfaces;

public interface IController<T> {

	T onCreate(T t);

	T onRead(T t);

	T onUpdate(T t);

	boolean onDelete(T t);

}
