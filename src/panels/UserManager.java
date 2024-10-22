package panels;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.LinkedHashMap;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JPanel;

import com.fasterxml.jackson.databind.ObjectMapper;

import api.UserApi;
import beans.User;
import common.Constants;
import components.CRUDTable;
import components.OptionPane;
import controller.UserController;

public class UserManager extends JPanel {
	private static final long serialVersionUID = 1L;

	private CRUDTable<User> table;
	private UserController userController;
	private UserApi userApi;

	public UserManager() {
		super();
		initialize();
	}

	private void initialize() {
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);

		LinkedHashMap<String, Action> events = new LinkedHashMap<>();
		events.put(Constants.UPDATE, new UpdateEvent());
		events.put(Constants.DELETE, new DeleteEvent());

		table = new CRUDTable<>(User.getFields());
		table.initialize(events, new CreateEvent());

		userApi = new UserApi();
		userController = new UserController(table, userApi);
		table.updateData(userApi.getAll());

		this.add(table, BorderLayout.CENTER);
	}

	private class UpdateEvent extends AbstractAction {
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			Object bean = table.getSelectedBean();
			if (bean instanceof User) {
				User user = (User) bean;
				userController.onUpdate(user);
			}
		}
	}

	private class DeleteEvent extends AbstractAction {
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			Object bean = table.getSelectedBean();
			if (bean instanceof User) {
				User user = (User) bean;
				userController.onDelete(user);
			}
		}
	}

	private class CreateEvent extends AbstractAction {
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent event) {
			userController.onCreate();
		}
	}

}
