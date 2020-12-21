package controller;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import beans.Bike;
import beans.Park;
import beans.ResponseCustom;
import interfaces.IController;

public class ParkController implements IController<Park> {

	public static final String PATH = "https://eco-bike.herokuapp.com/api/";

	private Client client;

	public ParkController() {
		client = ClientBuilder.newClient();
	}

	
	@Override
	public Park onCreate(Park park) {
		System.out.println(park);
		WebTarget webTarget = client.target(PATH).path("parks").path(park.getId());

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(park, MediaType.APPLICATION_JSON));

		ResponseCustom<Park> res = response.readEntity(ResponseCustom.class);

		if (res.getStatus() == 1) {
			return res.getT();
		}
		return null;
	}

	@Override
	public Park onRead(Park park) {
		System.out.println(park);
		WebTarget webTarget = client.target(PATH).path("parks").path(park.getId());

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();

		ResponseCustom<Park> res = response.readEntity(ResponseCustom.class);
		if (res.getStatus() == 1) {
			return res.getT();
		}
		return null;
	}

	@Override
	public Park onUpdate(Park park) {
		System.out.println(park);
		WebTarget webTarget = client.target(PATH).path("parks").path(park.getId());

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.put(Entity.entity(park, MediaType.APPLICATION_JSON));

		ResponseCustom<Park> res = response.readEntity(ResponseCustom.class);
		if (res.getStatus() == 1) {
			return res.getT();
		}
		return null;
	}

	@Override
	public boolean onDelete(Park park) {
		System.out.println(park);
		WebTarget webTarget = client.target(PATH).path("parks").path(park.getId());

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.delete();

		ResponseCustom<Park> res = response.readEntity(ResponseCustom.class);

		if (res.getStatus() == 1) {
			return true;
		}
		return false;
	}

}
