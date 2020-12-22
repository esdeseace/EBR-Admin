package panels;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.LinkedHashMap;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JDialog;
import javax.swing.JPanel;

import com.fasterxml.jackson.databind.ObjectMapper;

import api.BikeApi;
import beans.Bike;
import common.Constants;
import components.CRUDTable;
import components.OptionPane;
import controller.BikeController;

public class BikeManager extends JDialog {
	private static final long serialVersionUID = 1L;

	private CRUDTable<Bike> table;
	private BikeController bikeController;
	private BikeApi bikeApi;

	public BikeManager() {
		super();
		initialize();
	}

	private void initialize() {
		BorderLayout layout = new BorderLayout();
		this.setTitle("Thông tin xe");
		this.setLayout(layout);
		this.setSize(Constants.DIALOG_WIDTH, Constants.DIALOG_HEIGHT);

		LinkedHashMap<String, Action> events = new LinkedHashMap<>();
		events.put(Constants.UPDATE, new UpdateEvent());
		events.put(Constants.DELETE, new DeleteEvent());

		table = new CRUDTable<>(Bike.getFields());
		table.initialize(events, new CreateEvent());

		bikeApi = new BikeApi();
		bikeController = new BikeController(table, bikeApi);

		this.add(table, BorderLayout.CENTER);
		this.setLocationRelativeTo(null);
	}

	public void showDialog(String parkId) {
		bikeApi.setParkId(parkId);
		table.updateData(bikeApi.getAll());
		this.setModal(true);
		this.setVisible(true);
	}

	private class UpdateEvent extends AbstractAction {
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			Object bean = table.getSelectedBean();

			if (bean instanceof Bike) {
				Bike bike = (Bike) bean;
				bikeController.onUpdate(bike);
			}

		}
	}

	private class DeleteEvent extends AbstractAction {
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			Object bean = table.getSelectedBean();
			if (bean instanceof Bike) {
				Bike bike = (Bike) bean;
				bikeController.onDelete(bike);
			}
		}
	}

	private class CreateEvent extends AbstractAction {
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent event) {
			bikeController.onCreate();
		}
	}

}
