package panels;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;

import components.CRUDTable;
import interfaces.CRUD;
import models.Model;

public class UserManager extends JPanel {
	private static final long serialVersionUID = 1L;

	public UserManager() {
		super();
		initialize();
	}

	private void initialize() {
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);

		Map<String, String> fields = new HashMap<String, String>();
		fields.put("x", "X");
		fields.put("y", "Y");

		List<Model> data = new ArrayList<>();
		data.add(new Model("a", 3));
		data.add(new Model("b", 2));
		data.add(new Model("c", 1));

		CRUDTable<Model> table = new CRUDTable<>(data, fields, new CRUD<Model>() {

			@Override
			public void onCreate() {
				// TODO Auto-generated method stub
				System.out.print("Hello");
			}

			@Override
			public void onRead(Model t) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onUpdate(Model t) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onDelete(Model t) {
				// TODO Auto-generated method stub

			}
		});

		this.add(table, BorderLayout.CENTER);

		data.add(new Model("abacac", 1));
		table.updateData();
	}
}
