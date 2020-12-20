package api;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public abstract class Api {
	public static final String PATH = "https://eco-bike.herokuapp.com/api";
	public static Client client = ClientBuilder.newClient();
}
