package panels;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import api.ParkApi;

import beans.Park;
import beans.User;
import components.CRUDTable;
import controller.ParkController;


public class ParkManager extends JPanel {
	private static final long serialVersionUID = 1L;

	
	public ParkManager() {
		super();
		initialize();
	}
	private void initialize() {
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);

		ArrayList<Park> data = ParkApi.getAllParks();
		ParkController parkController = new ParkController();
		CRUDTable<Park> table = new CRUDTable<>(data, Park.getFields(), parkController);
//		System.out.println(data);
		this.add(table, BorderLayout.CENTER);
	}
	
}
