package api;

import java.util.ArrayList;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import beans.Bike;

public class BikeApi {
	public static ArrayList<Bike> getAllBikes() {
		WebTarget webTarget = Api.client.target(Api.PATH);

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();

		ArrayList<Bike> res = response.readEntity(new GenericType<ArrayList<Bike>>() {
		});

		return res;
	}
}
