package components;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

	private JButton createButton;
	private JTable table;
	private DefaultTableModel tableModel;

	public CRUDTable(ArrayList<T> data, LinkedHashMap<String, String> fields, IController<T> callback) {
		this.data = data;
		this.callback = callback;
		this.fields = fields;
		initialize();
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
		table = new JTable(tableModel);
		table.getColumnModel().getColumn(0).setMinWidth(0);
		table.getColumnModel().getColumn(0).setMaxWidth(0);
		this.add(new JScrollPane(table), BorderLayout.CENTER);

		createButton = new JButton(CREATE);
		this.add(new JScrollPane(createButton), BorderLayout.NORTH);
		createButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (callback != null) {
					callback.onCreate();
					updateData();
				}
			}
		});

		this.updateData();

		this.addButtonToTable(READ, columnNames.size() - 3, new AbstractAction() {

			private static final long serialVersionUID = 1L;

			@SuppressWarnings("unchecked")
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.convertRowIndexToModel(table.getEditingRow());
				T model = (T) tableModel.getValueAt(selectedRow, 0);
				System.out.println(model);
				callback.onRead(model);
			}
		});

		this.addButtonToTable(UPDATE, columnNames.size() - 2, new AbstractAction() {

			private static final long serialVersionUID = 1L;

			@SuppressWarnings("unchecked")
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.convertRowIndexToModel(table.getEditingRow());
				T model = (T) tableModel.getValueAt(selectedRow, 0);
				System.out.println(model);
				callback.onUpdate(model);
			}
		});

		this.addButtonToTable(DELETE, columnNames.size() - 1, new AbstractAction() {

			private static final long serialVersionUID = 1L;

			@SuppressWarnings("unchecked")
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.convertRowIndexToModel(table.getEditingRow());
				T model = (T) tableModel.getValueAt(selectedRow, 0);
				System.out.println(model);
				callback.onDelete(model);
			}
		});

	}

	public void updateData() {
		this.updateData(this.data);
	}

	public void updateData(ArrayList<T> datas) {
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

	private void addButtonToTable(String name, int position, Action action) {
		TableButton buttonTable = new TableButton(name, action);
		TableColumn column = table.getColumnModel().getColumn(position);
		column.setCellRenderer(buttonTable.getButtonsRenderer());
		column.setCellEditor(buttonTable.getButtonEditor(table));
	}

}
