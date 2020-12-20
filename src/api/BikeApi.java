package api;

import java.util.ArrayList;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import beans.Bike;

public class BikeApi {

	public static ArrayList<Bike> getAll() {
		try {
			WebTarget webTarget = Api.client.target("https://eco-bike.herokuapp.com/api/bikes");

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

	public Bike update(Bike bike) {
		try {
			WebTarget webTarget = Api.client.target(Api.PATH).path("books").path(bike.getId());

			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			Response response = invocationBuilder.post(Entity.entity(bike, MediaType.APPLICATION_JSON));

			Bike res = response.readEntity(Bike.class);
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
