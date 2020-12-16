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

		ArrayList<User> data = UserApi.getAllUsers();
		UserController userController = new UserController();
		CRUDTable<User> table = new CRUDTable<>(data, User.getFields(), userController);
//		System.out.println(data);
		this.add(table, BorderLayout.CENTER);
	}
}
