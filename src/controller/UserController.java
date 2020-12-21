package controller;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import api.UserApi;
import beans.Bike;
import beans.ResponseCustom;
import beans.User;
import interfaces.IController;

public class UserController implements IController<User> {
	public static final String PATH = "https://eco-bike.herokuapp.com/api/";

	private Client client;

	public UserController() {
		client = ClientBuilder.newClient();
	}
	
	@Override
	public User onCreate(User user) {
		System.out.print(user);
		return UserApi.add(user);
	}

	@Override
	public User onRead(User user) {
		System.out.println(user);
		return user;
	}

	@Override
	public User onUpdate(User user) {
		System.out.println(user);
		
		return UserApi.update(user);
	}

	@Override
	public boolean onDelete(User user) {
		System.out.println(user);
		return UserApi.delete(user.getId());
	}

}
