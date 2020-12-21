package panels;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.fasterxml.jackson.databind.ObjectMapper;

import api.ParkApi;

import beans.Park;
import beans.User;
import common.Constants;
import components.CRUDTable;
import components.OptionPane;
import controller.ParkController;

public class ParkManager extends JPanel {
	private static final long serialVersionUID = 1L;

	private CRUDTable<User> table;
	private ParkController parkController;
	private OptionPane<Park> updateDialog;
	private OptionPane<Park> createDialog;

	
	public ParkManager() {
		super();
		initialize();
	}
	private void initialize() {
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);

		ArrayList<Park> data = ParkApi.getAllParks();
		ParkController parkController = new ParkController();
		CRUDTable<Park> table = new CRUDTable<>( Park.getFields());
//		System.out.println(data);

		ArrayList<String> names = new ArrayList<>();
		names.add(Constants.UPDATE);
		names.add(Constants.DELETE);

		LinkedHashMap<String, Action> events = new LinkedHashMap<>();
		events.put(Constants.UPDATE, new UpdateEvent());
		events.put(Constants.DELETE, new DeleteEvent());

		table = new CRUDTable<>(Park.getFields());
		table.initialize(events, new CreateEvent());

		parkController = new ParkController();
		table.updateData(ParkApi.getAllParks());

		updateDialog = new OptionPane<>(User.getUpdateFields());
		updateDialog.initialize("Cập nhật bãi xe", "Cập nhật");

		createDialog = new OptionPane<>(User.getCreateFields());
		createDialog.initialize("Thêm bãi xe", "Thêm");

		
		this.add(table, BorderLayout.CENTER);
	}
	

	private class UpdateEvent extends AbstractAction {
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			Object bean = table.getSelectedBean();
			
			if (bean instanceof Park) {
				updateDialog.updateDate( (Park) bean);
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
			System.out.println(bean);
			if (bean instanceof Park) {
				Park user = (Park) bean;
				int isDelete = JOptionPane.showConfirmDialog(null,
						"Việc này không thể hoàn tác. Bạn có chắc chắn muốn xóa không?!", "Xóa",
						JOptionPane.YES_NO_OPTION);
				if (isDelete == JOptionPane.YES_OPTION) {
					parkController.onDelete(user);
				}
			}
		}
	}

	private class CreateEvent extends AbstractAction {
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			LinkedHashMap<String, String> result = createDialog.showDialog();
			if (result != null) {
				ObjectMapper mapper = new ObjectMapper();
				Park park = mapper.convertValue(result, Park.class);
				parkController.onCreate(park);
			}
		}
	}
	
}
