package api;

import java.util.ArrayList;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import beans.User;
import common.Constants;
import helpers.ResponseCustom;
import interfaces.IApi;

public class UserApi implements IApi<User> {

	@Override
	public ArrayList<User> getAll() {
		try {
			WebTarget webTarget = Constants.client.target(Constants.PATH).path("users");

			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			Response response = invocationBuilder.get();

			ArrayList<User> res = response.readEntity(new GenericType<ArrayList<User>>() {
			});

			return res;
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	@Override
	public User add(User user) {
		WebTarget webTarget = Constants.client.target(Constants.PATH).path("users");

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(user, MediaType.APPLICATION_JSON));

		ResponseCustom<User> res = response.readEntity(ResponseCustom.class);

		if (res.getStatus() == 1) {
			return res.getT();
		}
		return null;
	}

	@Override
	public User update(User user) {
		System.out.println(user);
		WebTarget webTarget = Constants.client.target(Constants.PATH).path("users").path(user.getId());

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.put(Entity.entity(user, MediaType.APPLICATION_JSON));

		ResponseCustom<User> res = response.readEntity(ResponseCustom.class);
		if (res.getStatus() == 1) {
			return res.getT();
		}
		return null;
	}

	@Override
	public boolean delete(User user) {
		System.out.println(user);
		WebTarget webTarget = Constants.client.target(Constants.PATH).path("users").path(user.getId());

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.delete();

		ResponseCustom<User> res = response.readEntity(ResponseCustom.class);

		if (res.getStatus() == 1) {
			return true;
		}
		return false;
	}

}