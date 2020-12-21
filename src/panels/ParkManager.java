package panels;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.LinkedHashMap;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JPanel;

import com.fasterxml.jackson.databind.ObjectMapper;

import api.ParkApi;
import beans.Park;
import common.Constants;
import components.CRUDTable;
import components.OptionPane;
import controller.ParkController;

public class ParkManager extends JPanel {
	private static final long serialVersionUID = 1L;

	private CRUDTable<Park> table;
	private ParkController parkController;
	private OptionPane<Park> updateDialog;
	private OptionPane<Park> createDialog;
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

		updateDialog = new OptionPane<>(Park.getUpdateFields());
		updateDialog.initialize("Cập nhật bãi xe", "Cập nhật");

		createDialog = new OptionPane<>(Park.getCreateFields());
		createDialog.initialize("Thêm bãi xe", "Thêm");

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
				updateDialog.updateDate(park);
			}

			LinkedHashMap<String, String> result = updateDialog.showDialog();
			if (result != null) {
				ObjectMapper mapper = new ObjectMapper();
				Park park = mapper.convertValue(result, Park.class);
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
			LinkedHashMap<String, String> result = createDialog.showDialog();
			if (result != null) {
				ObjectMapper mapper = new ObjectMapper();
				Park park = mapper.convertValue(result, Park.class);
				parkController.onCreate(park);
			}
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
