package controller;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
		WebTarget webTarget = client.target(PATH).path("users");

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(user, MediaType.APPLICATION_JSON));

		ResponseCustom<User> res = response.readEntity(ResponseCustom.class);

		if (res.getStatus() == 1) {
			return res.getT();
		}
		return null;
	}

	@Override
	public User onRead(User user) {
		System.out.print(user);
		WebTarget webTarget = client.target(PATH).path("users").path(user.getId());

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();

		ResponseCustom<User> res = response.readEntity(ResponseCustom.class);
		if (res.getStatus() == 1) {
			return res.getT();
		}
		return null;
	}

	@Override
	public User onUpdate(User user) {
		System.out.println(user);
		WebTarget webTarget = client.target(PATH).path("users").path(user.getId());

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.put(Entity.entity(user, MediaType.APPLICATION_JSON));

		ResponseCustom<User> res = response.readEntity(ResponseCustom.class);
		if (res.getStatus() == 1) {
			return res.getT();
		}
		return null;
	}

	@Override
	public boolean onDelete(User user) {
		WebTarget webTarget = client.target(PATH).path("users").path(user.getId());

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.delete();

		ResponseCustom<User> res = response.readEntity(ResponseCustom.class);

		if (res.getStatus() == 1) {
			return true;
		}
		return false;
	}

}
