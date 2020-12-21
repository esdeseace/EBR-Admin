package api;

import java.util.ArrayList;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import beans.Park;
import beans.ResponseCustom;
import common.Constants;
import interfaces.IApi;

public class ParkApi implements IApi<Park> {

	public ArrayList<Park> getAll() {
		WebTarget webTarget = Constants.client.target("https://my-json-server.typicode.com/nvthong99/fakeapi/parks");

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.accept("application/json").get(Response.class);
		ArrayList<Park> res = response.readEntity(new GenericType<ArrayList<Park>>() {
		});

		return res;
	}

	public Park add(Park park) {
		WebTarget webTarget = Constants.client.target(Constants.PATH).path("parks");

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(park, MediaType.APPLICATION_JSON));

		ResponseCustom<Park> res = response.readEntity(ResponseCustom.class);

		if (res.getStatus() == 1) {
			return res.getT();
		}
		return null;
	}

	public Park update(Park park) {
		WebTarget webTarget = Constants.client.target(Constants.PATH).path("parks").path(park.getId());

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.put(Entity.entity(park, MediaType.APPLICATION_JSON));

		ResponseCustom<Park> res = response.readEntity(ResponseCustom.class);
		if (res.getStatus() == 1) {
			return res.getT();
		}
		return null;
	}

	public boolean delete(Park park) {
		WebTarget webTarget = Constants.client.target(Constants.PATH).path("parks").path(park.getId());

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.delete();

		ResponseCustom<Park> res = response.readEntity(ResponseCustom.class);

		if (res.getStatus() == 1) {
			return true;
		}
		return false;
	}
}