package api;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public class Api {
	public static final String PATH = "https://my-json-server.typicode.com/nvthong99/fakeapi/users";
	public static Client client = ClientBuilder.newClient();
}
