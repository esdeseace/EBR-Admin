package controller;

import beans.User;
import interfaces.IController;

public class UserController implements IController<User> {

	@Override
	public User onCreate(User user) {
		System.out.println(user);
		return user;
	}

	@Override
	public User onRead(User user) {
		System.out.println(user);
		return user;
	}

	@Override
	public User onUpdate(User user) {
		System.out.println(user);
		return user;
	}

	@Override
	public boolean onDelete(User user) {
		System.out.println(user);
		return false;
	}

}
