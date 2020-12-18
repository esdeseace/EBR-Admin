package panels;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import api.UserApi;
import beans.User;
import components.CRUDTable;
import controller.UserController;

public class UserManager extends JPanel {
	private static final long serialVersionUID = 1L;

	public UserManager() {
		super();
		initialize();
	}

	private void initialize() {
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);

		CRUDTable<User> table = new CRUDTable<>(User.getFields());
		UserController userController = new UserController();
		table.setController(userController);
		table.updateData(UserApi.getAll());

		this.add(table, BorderLayout.CENTER);
	}
}
