package common;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Constants {
	// Frame
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;

	// Dialog
	public static final int DIALOG_WIDTH = 1000;
	public static final int DIALOG_HEIGHT = 500;

	// Api
	public static final String PATH = "https://eco-bike.herokuapp.com/api";
	public static final Client client = ClientBuilder.newClient();

	// Controller
	public final static String CREATE = "Thêm";
	public final static String READ = "Thông tin xe";
	public final static String UPDATE = "Sửa";
	public final static String DELETE = "Xóa";

	// Mapper
	public final static ObjectMapper mapper = new ObjectMapper();

}
