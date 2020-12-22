package panels;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.LinkedHashMap;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JPanel;

import api.ParkApi;
import beans.Park;
import common.Constants;
import components.CRUDTable;
import controller.ParkController;

public class ParkManager extends JPanel {
	private static final long serialVersionUID = 1L;

	private CRUDTable<Park> table;
	private ParkController parkController;
	private ParkApi parkApi;
	private BikeManager bikeManager;

	public ParkManager() {
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

		table = new CRUDTable<>(Park.getFields());
		table.initialize(events, new CreateEvent());

		parkApi = new ParkApi();
		parkController = new ParkController(table, parkApi);
		table.updateData(parkApi.getAll());

		bikeManager = new BikeManager();

		this.add(table, BorderLayout.CENTER);
	}

	private class UpdateEvent extends AbstractAction {
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			Object bean = table.getSelectedBean();

			if (bean instanceof Park) {
				Park park = (Park) bean;
				parkController.onUpdate(park);
			}
		}
	}

	private class DeleteEvent extends AbstractAction {
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			Object bean = table.getSelectedBean();
			if (bean instanceof Park) {
				Park park = (Park) bean;
				parkController.onDelete(park);
			}
		}
	}

	private class CreateEvent extends AbstractAction {
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent event) {
			parkController.onCreate();
		}
	}

	private class ReadEvent extends AbstractAction {
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent event) {
			Object bean = table.getSelectedBean();
			if (bean instanceof Park) {
				Park park = (Park) bean;
				bikeManager.showDialog(park.getId());
			}
		}
	}

}
