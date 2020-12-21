package interfaces;

import components.CRUDTable;

public class AController<T> {
	protected CRUDTable<T> table;

	public AController(CRUDTable<T> table) {
		this.table = table;
	}
}
