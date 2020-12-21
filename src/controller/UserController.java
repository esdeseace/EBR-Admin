package controller;

import api.UserApi;
import beans.User;
import components.CRUDTable;
import interfaces.AController;

public class UserController extends AController<User> {

	public UserController(CRUDTable<User> table, UserApi api) {
		super(table, api);
	}

}
