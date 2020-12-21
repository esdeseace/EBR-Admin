package panels;

import java.awt.BorderLayout;
import java.util.LinkedHashMap;

import javax.swing.Action;
import javax.swing.JPanel;

import beans.Bike;
import components.CRUDTable;

public class UsedBikeManager extends JPanel {
	private static final long serialVersionUID = 1L;

	private CRUDTable<Bike> table;

	public UsedBikeManager() {
		super();
		initialize();
	}

	private void initialize() {
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);

		LinkedHashMap<String, Action> events = new LinkedHashMap<>();
		table = new CRUDTable<>(Bike.getFields());
		table.initialize(events, null);

		this.add(table, BorderLayout.CENTER);
	}
}
