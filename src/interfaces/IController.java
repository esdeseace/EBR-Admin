package interfaces;

public interface IController<T> {

	void onCreate(T t);

	void onRead(T t);

	void onUpdate(T t);

	void onDelete(T t);

}
