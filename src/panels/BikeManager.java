package panels;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import api.BikeApi;
import beans.Bike;
import components.CRUDTable;
import controller.BikeController;

public class BikeManager extends JPanel {
	private static final long serialVersionUID = 1L;

	public BikeManager() {
		super();
		initialize();
	}

	private void initialize() {
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);

		CRUDTable<Bike> table = new CRUDTable<>(Bike.getFields());
		BikeController bikeController = new BikeController();
		table.setController(bikeController);
		table.updateData(BikeApi.getAll());

		this.add(table, BorderLayout.CENTER);
	}
}
