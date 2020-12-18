package api;

import java.util.ArrayList;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import beans.User;

public class UserApi {

	public static ArrayList<User> getAll() {
		WebTarget webTarget = Api.client.target("https://my-json-server.typicode.com/nvthong99/fakeapi/users");

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();

		ArrayList<User> res = response.readEntity(new GenericType<ArrayList<User>>() {
		});

		return res;
	}

	public boolean update(int id) {
		return true;
	}

	public boolean delete(int id) {
		return true;
	}

}
