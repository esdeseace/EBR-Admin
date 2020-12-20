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
	private String created_at;
	private String updated_at;
	
	public User(String id, String name, String username, String password, int money, String created_at,
			String updated_at) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.money = money;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}


	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}


	
	public User() {
		super();
	}

//	public User(int id, String name, String username, String password, int balance) {
//		this.id = id;
//		this.name = name;
//		this.username = username;
//		this.password = password;
//		this.balance = balance;
//	}

	public static LinkedHashMap<String, String> getFields() {
		LinkedHashMap<String, String> fields = new LinkedHashMap<String, String>();
		fields.put("id", "id");
		fields.put("name", "Họ tên");
		fields.put("username", "Tài khảo");
//		fields.put("password", "Mật khẩu");
		fields.put("money", "Số dư");
		return fields;
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
