package components;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import interfaces.CRUD;

public class CRUDTable<T> extends JPanel {
	private static final long serialVersionUID = 1L;

	private List<T> data;
	private Map<String, String> fields;
	private CRUD<T> callback;

	private DefaultTableModel tableModel;

	private JButton createButton;

	public CRUDTable(List<T> data, Map<String, String> fields, CRUD<T> callback) {
		this.data = data;
		this.callback = callback;
		this.fields = fields;
		initialize();
	}

	private void initialize() {
		List<String> columnNames = new ArrayList<>();
		Set<String> keys = fields.keySet();

		for (String key : keys) {
			String name = fields.get(key);
			columnNames.add(name);
		}

		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);

		tableModel = new DefaultTableModel(null, columnNames.toArray());
		JTable table = new JTable(tableModel);
		this.add(new JScrollPane(table), BorderLayout.CENTER);

		createButton = new JButton("Create");
		this.add(new JScrollPane(createButton), BorderLayout.NORTH);
		createButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (callback != null) {
					callback.onCreate();
				}
			}
		});

		updateData();
	}

	public void updateData() {
		this.updateData(this.data);
	}

	public void updateData(List<T> datas) {
		Set<String> keys = fields.keySet();
		for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
			tableModel.removeRow(i);
		}

		for (T model : data) {
			List<String> values = new ArrayList<>();

			for (String key : keys) {
				try {
					Field field = model.getClass().getDeclaredField(key);
					field.setAccessible(true);

					Object obj = field.get(model);
					String value = obj != null ? obj.toString() : "";
					values.add(value);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			tableModel.addRow(values.toArray());
		}
	}
x
}
