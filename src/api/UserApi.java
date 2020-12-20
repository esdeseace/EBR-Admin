package api;

import java.util.ArrayList;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import beans.User;

public class UserApi {
	public static ArrayList<User> getAllUsers() {
		WebTarget webTarget = Api.client.target("https://eco-bike.herokuapp.com/api/users");

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();

		ArrayList<User> res = response.readEntity(new GenericType<ArrayList<User>>() {
		});

		return res;
	}
}
