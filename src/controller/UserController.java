package controller;

import beans.User;
import interfaces.IController;

public class UserController implements IController<User> {

	@Override
	public void onCreate(User user) {
		System.out.println(user);
	}

	@Override
	public void onRead(User user) {
		System.out.println(user);
	}

	@Override
	public void onUpdate(User user) {
		System.out.println(user);
	}

	@Override
	public void onDelete(User user) {
		System.out.println(user);
	}

}
