package beans;

import java.util.LinkedHashMap;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("user")
public class User {
	private String id;
	private String name;
	private String username;
	private String password;
	private int money;

	public User() {
		super();
	}

	public User(String id, String name, String username, String password, int money) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.money = money;
	}

	public static LinkedHashMap<String, String> getFields() {
		LinkedHashMap<String, String> fields = new LinkedHashMap<String, String>();
		fields.put("id", "id");
		fields.put("name", "Họ tên");
		fields.put("username", "Tài khảo");
//		fields.put("password", "Mật khẩu");
		fields.put("money", "Số dư");
		return fields;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password + ", money="
				+ money + "]";
	}

}
