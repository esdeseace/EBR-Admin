package common;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public class Constants {
	// Frame
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;

	// Api
	public static final String PATH = "https://eco-bike.herokuapp.com/api";
	public static final Client client = ClientBuilder.newClient();

	// Controller
	public final static String CREATE = "Thêm";
	public final static String READ = "Chi tiết";
	public final static String UPDATE = "Sửa";
	public final static String DELETE = "Xóa";

}
