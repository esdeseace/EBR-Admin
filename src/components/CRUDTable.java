package components;

import java.awt.BorderLayout;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import common.Constants;

public class CRUDTable<T> extends JPanel {
	private static final long serialVersionUID = 1L;

	private ArrayList<T> data;
	private LinkedHashMap<String, String> fields;
	private ArrayList<String> columnNames;

	private JTable table;
	private DefaultTableModel tableModel;

	public CRUDTable(LinkedHashMap<String, String> fields) {
		this.fields = fields;
	}

	public void initialize(LinkedHashMap<String, Action> events, Action createEvent) {

		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);

		Set<String> keys = fields.keySet();
		this.columnNames = new ArrayList<>();
		this.columnNames.add("hidden");

		for (String key : keys) {
			String name = fields.get(key);
			this.columnNames.add(name);
		}

		final int size = this.columnNames.size();

		Set<String> buttonNames = events.keySet();
		for (String name : buttonNames) {
			this.columnNames.add(name);
		}

		tableModel = new DefaultTableModel(null, columnNames.toArray());
		table = new JTable(tableModel) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				if (column >= size)
					return true;
				return false;
			};
		};

		table.getColumnModel().getColumn(0).setMaxWidth(0);
		this.add(new JScrollPane(table), BorderLayout.CENTER);

		if (createEvent != null) {
			JButton createButton = new JButton(Constants.CREATE);
			createButton.addActionListener(createEvent);
			this.add(new JScrollPane(createButton), BorderLayout.NORTH);
		}

		int index = 0;
		for (String name : buttonNames) {
			this.addButtonCell(name, size + index++, events.get(name));
		}
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

		for (T bean : data) {
			ArrayList<Object> values = new ArrayList<>();
			values.add(bean);

			for (String key : keys) {
				try {
					Field field = bean.getClass().getDeclaredField(key);
					field.setAccessible(true);

					Object value = field.get(bean);
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

	public Object getSelectedBean() {
		int selectedRow = table.convertRowIndexToModel(table.getEditingRow());
		Object bean = tableModel.getValueAt(selectedRow, 0);
		return bean;
	}

}
