package components;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import interfaces.IController;

public class CRUDTable<T> extends JPanel {
	private static final long serialVersionUID = 1L;

	private final String CREATE = "Thêm";
	private final String READ = "Chi tiết";
	private final String UPDATE = "Sửa";
	private final String DELETE = "Xóa";

	private IController<T> callback;

	private ArrayList<T> data;
	private LinkedHashMap<String, String> fields;
	private ArrayList<String> columnNames;

	private JTable table;
	private DefaultTableModel tableModel;

	public CRUDTable(LinkedHashMap<String, String> fields) {
		this.fields = fields;
		initialize();
	}

	public void setController(IController<T> callback) {
		this.callback = callback;
	}

	private void initialize() {

		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);

		Set<String> keys = fields.keySet();
		this.columnNames = new ArrayList<>();
		this.columnNames.add("hidden");

		for (String key : keys) {
			String name = fields.get(key);
			this.columnNames.add(name);
		}

		columnNames.add(READ);
		columnNames.add(UPDATE);
		columnNames.add(DELETE);

		tableModel = new DefaultTableModel(null, columnNames.toArray());
		table = new JTable(tableModel) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				if (column >= columnNames.size() - 3)
					return true;
				return false;
			};
		};
		table.getColumnModel().getColumn(0).setMinWidth(0);
		table.getColumnModel().getColumn(0).setMaxWidth(0);
		this.add(new JScrollPane(table), BorderLayout.CENTER);

		JButton createButton = new JButton(CREATE);
		createButton.addActionListener(new CreateEvent());
		this.add(new JScrollPane(createButton), BorderLayout.NORTH);

		this.addButtonCell(READ, columnNames.size() - 3, new ReadEvent());
		this.addButtonCell(UPDATE, columnNames.size() - 2, new UpdateEvent());
		this.addButtonCell(DELETE, columnNames.size() - 1, new DeleteEvent());
	}

	public void updateData() {
		this.updateData(this.data);
	}

	public void updateData(ArrayList<T> data) {
		this.data = data;
		Set<String> keys = fields.keySet();
		for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
			tableModel.removeRow(i);
		}

		for (T model : data) {
			ArrayList<Object> values = new ArrayList<>();
			values.add(model);

			for (String key : keys) {
				try {
					Field field = model.getClass().getDeclaredField(key);
					field.setAccessible(true);

					Object value = field.get(model);
					values.add(value);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			tableModel.addRow(values.toArray());
		}
	}

	private void addButtonCell(String name, int position, Action action) {
		ButtonCell buttonCell = new ButtonCell(name, action);
		TableColumn column = table.getColumnModel().getColumn(position);
		buttonCell.setColumnButton(column);
	}

	private class CreateEvent extends AbstractAction {

		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			callback.onCreate();
		}
	}

	private class UpdateEvent extends AbstractAction {

		private static final long serialVersionUID = 1L;

		@SuppressWarnings("unchecked")
		@Override
		public void actionPerformed(ActionEvent e) {
			int selectedRow = table.convertRowIndexToModel(table.getEditingRow());
			Object model = tableModel.getValueAt(selectedRow, 0);
			callback.onUpdate((T) model);
		}
	}

	private class DeleteEvent extends AbstractAction {

		private static final long serialVersionUID = 1L;

		@SuppressWarnings("unchecked")
		@Override
		public void actionPerformed(ActionEvent e) {
			int selectedRow = table.convertRowIndexToModel(table.getEditingRow());
			Object model = tableModel.getValueAt(selectedRow, 0);
			callback.onDelete((T) model);
		}
	}

	private class ReadEvent extends AbstractAction {

		private static final long serialVersionUID = 1L;

		@SuppressWarnings("unchecked")
		@Override
		public void actionPerformed(ActionEvent e) {
			int selectedRow = table.convertRowIndexToModel(table.getEditingRow());
			Object model = tableModel.getValueAt(selectedRow, 0);
			callback.onRead((T) model);
		}
	}

}
