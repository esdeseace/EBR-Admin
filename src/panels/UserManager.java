package panels;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JPanel;

import org.glassfish.jersey.spi.Contract;

import api.UserApi;
import beans.User;
import common.Constants;
import components.CRUDTable;
import controller.UserController;
import dialog.Dialog;

public class UserManager extends JPanel {
	private static final long serialVersionUID = 1L;

	private CRUDTable<User> table;
	private UserController userController;
	private Dialog<User> updateDialog;
	private Dialog<User> createDialog;

	public UserManager() {
		super();
		initialize();
	}

	private void initialize() {
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);

		ArrayList<String> names = new ArrayList<>();
		names.add(Constants.UPDATE);
		names.add(Constants.DELETE);

		ArrayList<Action> events = new ArrayList<>();
		events.add(new UpdateEvent());
		events.add(new DeleteEvent());

		table = new CRUDTable<>(User.getFields());
		table.initialize(names, events, new CreateEvent());

		userController = new UserController();
		table.updateData(UserApi.getAll());

		updateDialog = new Dialog<>(User.getUpdateFields());
		updateDialog.initialize("Cập nhật người dùng", "Cập nhật");

		createDialog = new Dialog<>(User.getCreateFields());
		createDialog.initialize("Thêm người dùng", "Thêm");

		this.add(table, BorderLayout.CENTER);
	}

	private class UpdateEvent extends AbstractAction {
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			Object bean = table.getSelectedBean();
			System.out.println(bean);
			if (bean instanceof User) {
				updateDialog.updateDate((User) bean);
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
