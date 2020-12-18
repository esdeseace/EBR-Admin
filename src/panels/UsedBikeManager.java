package panels;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import api.BikeApi;
import beans.Bike;
import components.CRUDTable;
import controller.BikeController;

public class UsedBikeManager extends JPanel {
	private static final long serialVersionUID = 1L;

	public UsedBikeManager() {
		super();
		initialize();
	}
	private void initialize() {
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);

		ArrayList<Bike> data = BikeApi.getAllBikes();
		BikeController bikeController = new BikeController();
		CRUDTable<Bike> table = new CRUDTable<>(data, Bike.getFields(), bikeController);

		this.add(table, BorderLayout.CENTER);
	}
}
