package api;

import java.util.ArrayList;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import beans.Bike;
import helpers.ResponseCustom;
import interfaces.IApi;
import common.Constants;

public class BikeApi implements IApi<Bike> {

	private String parkId;

	public void setParkId(String parkId) {
		this.parkId = parkId;
	}

	public ArrayList<Bike> getAll() {
		try {
			WebTarget webTarget = Constants.client.target(Constants.PATH).path("bikes").path("fromPark").path(parkId);

			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			Response response = invocationBuilder.get();

			ArrayList<Bike> res = response.readEntity(new GenericType<ArrayList<Bike>>() {
			});

			return res;
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}
	public ArrayList<Bike> getAlls() {
		try {
			WebTarget webTarget = Constants.client.target(Constants.PATH).path("bikes");

			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			Response response = invocationBuilder.get();

			ArrayList<Bike> res = response.readEntity(new GenericType<ArrayList<Bike>>() {
			});

			return res;
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	public Bike add(Bike bike) {
		WebTarget webTarget = Constants.client.target(Constants.PATH).path("bikes");

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(bike, MediaType.APPLICATION_JSON));

		ResponseCustom<Bike> res = response.readEntity(ResponseCustom.class);

		if (res.getStatus() == 1) {
			return res.getT();
		}
		return null;
	}

	public Bike update(Bike bike) {
		WebTarget webTarget = Constants.client.target(Constants.PATH).path("bikes").path(bike.getId());

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.put(Entity.entity(bike, MediaType.APPLICATION_JSON));

		ResponseCustom<Bike> res = response.readEntity(ResponseCustom.class);
		if (res.getStatus() == 1) {
			return res.getT();
		}
		return null;
	}

	public boolean delete(Bike bike) {
		System.out.println(bike);
		WebTarget webTarget = Constants.client.target(Constants.PATH).path("bikes").path(bike.getId());

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.delete();

		ResponseCustom<Bike> res = response.readEntity(ResponseCustom.class);

		if (res.getStatus() == 1) {
			return true;
		}
		return false;
	}

}