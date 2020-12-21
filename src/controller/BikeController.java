package controller;

import java.util.ArrayList;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import api.BikeApi;
import beans.Bike;
import beans.ResponseCustom;
import interfaces.IController;

public class BikeController implements IController<Bike> {
	public static final String PATH = "https://eco-bike.herokuapp.com/api/";

	private Client client;

	public BikeController() {
		client = ClientBuilder.newClient();
	}

	@Override
	public Bike onCreate(Bike bike) {
		WebTarget webTarget = client.target(PATH).path("bikes").path(bike.getId());

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(bike, MediaType.APPLICATION_JSON));

		ResponseCustom<Bike> res = response.readEntity(ResponseCustom.class);

		if (res.getStatus() == 1) {
			return res.getT();
		}
		return null;
	}

	@Override
	public Bike onRead(Bike bike) {
		WebTarget webTarget = client.target(PATH).path("bikes").path(bike.getId());

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();

		ResponseCustom<Bike> res = response.readEntity(ResponseCustom.class);
		if (res.getStatus() == 1) {
			return res.getT();
		}
		return null;
	}

	@Override
	public Bike onUpdate(Bike bike) {
		WebTarget webTarget = client.target(PATH).path("bikes").path(bike.getId());

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.put(Entity.entity(bike, MediaType.APPLICATION_JSON));

		ResponseCustom<Bike> res = response.readEntity(ResponseCustom.class);
		if (res.getStatus() == 1) {
			return res.getT();
		}
		return null;
	}

	@Override
	public boolean onDelete(Bike bike) {
		WebTarget webTarget = client.target(PATH).path("bikes").path(bike.getId());

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.delete();

		ResponseCustom<Bike> res = response.readEntity(ResponseCustom.class);

		if (res.getStatus() == 1) {
			return true;
		}
		return false;
	}

}
