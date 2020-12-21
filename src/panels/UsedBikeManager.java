package panels;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.LinkedHashMap;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JPanel;

import com.fasterxml.jackson.databind.ObjectMapper;

import api.BikeApi;
import beans.Bike;
import common.Constants;
import components.CRUDTable;
import components.OptionPane;
import controller.BikeController;

public class UsedBikeManager extends JPanel {
	private static final long serialVersionUID = 1L;

	private CRUDTable<Bike> table;
	private BikeController bikeController;
	private OptionPane<Bike> updateDialog;
	private OptionPane<Bike> createDialog;
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

		updateDialog = new OptionPane<>(Bike.getUpdateFields());
		updateDialog.initialize("Cập nhật xe", "Cập nhật");

		createDialog = new OptionPane<>(Bike.getCreateFields());
		createDialog.initialize("Thêm xe", "Thêm");

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
				updateDialog.updateDate(bike);
			}

			LinkedHashMap<String, String> result = updateDialog.showDialog();
			if (result != null) {
				ObjectMapper mapper = new ObjectMapper();
				Bike park = mapper.convertValue(result, Bike.class);
				bikeController.onUpdate(park);
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
			LinkedHashMap<String, String> result = createDialog.showDialog();
			if (result != null) {
				ObjectMapper mapper = new ObjectMapper();
				Bike bike = mapper.convertValue(result, Bike.class);
				bikeController.onCreate(bike);
			}
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
