package interfaces;

import javax.swing.JOptionPane;

import components.CRUDTable;

public class AController<T> implements IController<T> {
	protected CRUDTable<T> table;
	protected IApi<T> api;

	public AController(CRUDTable<T> table, IApi<T> api) {
		this.table = table;
		this.api = api;
	}

	@Override
	public T onCreate(T t) {
		try {
			T newT = api.add(t);
			table.updateData(api.getAll());
			return newT;
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Create error", "Error", JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}

	@Override
	public T onRead(T t) {
		return null;
	}

	@Override
	public T onUpdate(T t) {
		try {
			T newT = api.update(t);
			table.updateData(api.getAll());
			return newT;
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Create error", "Error", JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}

	@Override
	public boolean onDelete(T t) {
		int isDelete = JOptionPane.showConfirmDialog(null,
				"Việc này không thể hoàn tác. Bạn có chắc chắn muốn xóa không?!", "Xóa", JOptionPane.YES_NO_OPTION);
		boolean isOk = false;
		if (isDelete == JOptionPane.YES_OPTION) {
			try {
				isOk = api.delete(t);
				table.updateData(api.getAll());
			} catch (Exception error) {
				error.printStackTrace();
				JOptionPane.showMessageDialog(null, "Create error", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		return isOk;
	}
}
