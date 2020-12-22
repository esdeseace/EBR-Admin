package controller;

import java.util.LinkedHashMap;

import api.UserApi;
import beans.User;
import common.Constants;
import components.CRUDTable;
import components.OptionPane;
import interfaces.AController;

public class UserController extends AController<User> {

	private OptionPane<User> updateDialog;
	private OptionPane<User> createDialog;

	public UserController(CRUDTable<User> table, UserApi api) {
		super(table, api);

		updateDialog = new OptionPane<>(User.getUpdateFields());
		updateDialog.initialize("Cập nhật người dùng", "Cập nhật");

		createDialog = new OptionPane<>(User.getCreateFields());
		createDialog.initialize("Thêm người dùng", "Thêm");
	}

	public User onCreate() {
		LinkedHashMap<String, String> result = createDialog.showDialog();
		if (result != null) {
			User user = Constants.mapper.convertValue(result, User.class);
			return super.onCreate(user);
		}
		return null;
	}

	@Override
	public User onUpdate(User user) {
		updateDialog.updateDate(user);
		LinkedHashMap<String, String> result = updateDialog.showDialog();
		if (result != null) {
			user = Constants.mapper.convertValue(result, User.class);
			return super.onUpdate(user);
		}
		return null;
	}

}
