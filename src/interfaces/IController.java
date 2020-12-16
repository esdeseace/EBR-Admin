package interfaces;

public interface IController<T> {
	void onCreate();

	void onRead(T t);

	void onUpdate(T t);

	void onDelete(T t);
}
