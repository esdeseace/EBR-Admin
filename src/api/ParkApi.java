package api;

import java.util.ArrayList;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import beans.Park;

public class ParkApi {
	public static ArrayList<Park> getAllParks() {
		WebTarget webTarget = Api.client.target("https://my-json-server.typicode.com/nvthong99/fakeapi/parks");

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.accept("application/json").get(Response.class);
		ArrayList<Park> res = response.readEntity(new GenericType<ArrayList<Park>>() {
		});
		
		return res;
	}
}
