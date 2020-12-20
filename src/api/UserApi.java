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

public class UserApi {

	public static ArrayList<User> getAll() {
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

	public User update(User user) {
		try {
			WebTarget webTarget = Constants.client.target(Constants.PATH).path("books").path(user.getId());

			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			Response response = invocationBuilder.post(Entity.entity(user, MediaType.APPLICATION_JSON));

			User res = response.readEntity(User.class);
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean delete(int id) {
		return true;
	}

}
