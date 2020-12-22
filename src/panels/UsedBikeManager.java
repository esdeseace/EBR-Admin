package panels;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.LinkedHashMap;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JPanel;

import api.BikeApi;
import beans.Bike;
import common.Constants;
import components.CRUDTable;
import controller.BikeController;

public class UsedBikeManager extends JPanel {
	private static final long serialVersionUID = 1L;

	private CRUDTable<Bike> table;
	private BikeController bikeController;
	private BikeApi bikeApi;
	private BikeManager bikeManager;

	public UsedBikeManager() {
		super();
		initialize();
	}

	private void initialize() {
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);

		LinkedHashMap<String, Action> events = new LinkedHashMap<>();
		events.put(Constants.READ, new ReadEvent());
		events.put(Constants.UPDATE, new UpdateEvent());
		events.put(Constants.DELETE, new DeleteEvent());

		table = new CRUDTable<>(Bike.getFields());
		table.initialize(events, new CreateEvent());

		bikeApi = new BikeApi();
		bikeController = new BikeController(table, bikeApi);
		table.updateData(bikeApi.getAlls());

		bikeManager = new BikeManager();

		this.add(table, BorderLayout.CENTER);
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

	private class ReadEvent extends AbstractAction {
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent event) {
			Object bean = table.getSelectedBean();
			if (bean instanceof Bike) {
				Bike bike = (Bike) bean;
				bikeManager.showDialog(bike.getId());
			}
		}
	}

}
