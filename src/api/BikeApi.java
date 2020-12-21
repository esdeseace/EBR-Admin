package api;

import java.util.ArrayList;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import beans.Bike;
import beans.ResponseCustom;
import beans.User;
import common.Constants;

public class BikeApi {

	public static ArrayList<Bike> getAll() {
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
	public static ArrayList<Bike> getAllBikeUsing() {
		try {
			WebTarget webTarget = Constants.client.target(Constants.PATH).path("/bikes/using");

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
	
	public static ArrayList<Bike> getBikesFromPark(String parkId) {
		try {
			WebTarget webTarget = Constants.client.target(Constants.PATH).path("bikes").path("fromPark").path(parkId);
	
			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			Response response = invocationBuilder.get();
	
			ArrayList<Bike> res = response.readEntity(new GenericType<ArrayList<Bike>>() {});

			return res;
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}
	
	public static Bike add(Bike bike) {
		WebTarget webTarget = Constants.client.target(Constants.PATH).path("bikes");

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(bike, MediaType.APPLICATION_JSON));

		ResponseCustom<Bike> res = response.readEntity(ResponseCustom.class);

		if (res.getStatus() == 1) {
			return res.getT();
		}
		return null;
	}

	public static Bike update(Bike bike) {
		WebTarget webTarget = Constants.client.target(Constants.PATH).path("bikes").path(bike.getId());

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.put(Entity.entity(bike, MediaType.APPLICATION_JSON));

		ResponseCustom<Bike> res = response.readEntity(ResponseCustom.class);
		if (res.getStatus() == 1) {
			return res.getT();
		}
		return null;
	}

	public static boolean delete(String id) {
		System.out.println(id);
		WebTarget webTarget = Constants.client.target(Constants.PATH).path("bikes").path(id);

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.delete();

		ResponseCustom<Bike> res = response.readEntity(ResponseCustom.class);

		if (res.getStatus() == 1) {
			return true;
		}
		return false;
	}

}
