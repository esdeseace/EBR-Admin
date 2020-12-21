package panels;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JPanel;

import api.BikeApi;
import api.UserApi;
import beans.Bike;
import beans.User;
import common.Constants;
import components.CRUDTable;
import controller.BikeController;
import controller.UserController;
import dialog.Dialog;


public class BikeManager extends JPanel {
	private static final long serialVersionUID = 1L;

	private CRUDTable<Bike> table;
	private BikeController bikeController;
	private Dialog<Bike> updateDialog;
	private Dialog<Bike> createDialog;
	
	public BikeManager() {
		super();
		initialize();
	}

//	private void initialize() {
//		BorderLayout layout = new BorderLayout();
//		this.setLayout(layout);
//
//		CRUDTable<Bike> table = new CRUDTable<>(Bike.getFields());
//		BikeController bikeController = new BikeController();
//		table.setController(bikeController);
//		table.updateData(BikeApi.getAll());
//
//		this.add(table, BorderLayout.CENTER);
//	}
	private void initialize() {
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);

		ArrayList<String> names = new ArrayList<>();
		names.add(Constants.UPDATE);
		names.add(Constants.DELETE);

		ArrayList<Action> events = new ArrayList<>();
		events.add(new UpdateEvent());
		events.add(new DeleteEvent());

		table = new CRUDTable<>(Bike.getFields());
		table.initialize(names, events, new CreateEvent());

		bikeController = new BikeController();
		table.updateData(BikeApi.getAll());

		updateDialog = new Dialog<>(Bike.getUpdateFields());
		updateDialog.initialize("Cập nhật xe", "Cập nhật");

		createDialog = new Dialog<>(Bike.getCreateFields());
		createDialog.initialize("Thêm xe", "Thêm");

		this.add(table, BorderLayout.CENTER);
	}

	private class UpdateEvent extends AbstractAction {
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			Object bean = table.getSelectedBean();
			System.out.println(bean);
			if (bean instanceof Bike) {
				updateDialog.updateDate((Bike) bean);
			}
			updateDialog.setModal(true);
			updateDialog.setVisible(true);
		}
	}

	private class DeleteEvent extends AbstractAction {
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			Object bean = table.getSelectedBean();
			System.out.println(bean);
		}
	}

	private class CreateEvent extends AbstractAction {
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			createDialog.setModal(true);
			createDialog.setVisible(true);
		}
	}
}
