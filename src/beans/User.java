package beans;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import helpers.FieldOption;

@JsonTypeName("user")
public class User {

	private String id;
	private String name;
	private String username;
	private String password;
	private int money;

	@JsonProperty("created_at")
	private Timestamp createdAt;

	@JsonProperty("updated_at")
	private Timestamp updatedAt;

	public User() {
		super();
	}

	public User(String id, String name, String username, String password, int money, Timestamp createdAt,
			Timestamp updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.money = money;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public static LinkedHashMap<String, String> getFields() {
		LinkedHashMap<String, String> fields = new LinkedHashMap<String, String>();
		fields.put("id", "id");
		fields.put("name", "Họ tên");
		fields.put("username", "Tài khảo");
		fields.put("money", "Số dư");
		return fields;
	}

	public static ArrayList<FieldOption> getUpdateFields() {
		ArrayList<FieldOption> fields = new ArrayList<>();
		fields.add(new FieldOption("id", "id", false, false));
		fields.add(new FieldOption("name", "Họ tên"));
		fields.add(new FieldOption("username", "Tài khảo", false, false));
		fields.add(new FieldOption("password", "Mật khẩu", true, true));
		fields.add(new FieldOption("money", "Số dư"));
		return fields;
	}

	public static ArrayList<FieldOption> getCreateFields() {
		ArrayList<FieldOption> fields = new ArrayList<>();
		fields.add(new FieldOption("name", "Họ tên"));
		fields.add(new FieldOption("username", "Tài khảo"));
		fields.add(new FieldOption("password", "Mật khẩu", true, true));
		fields.add(new FieldOption("money", "Số dư"));
		return fields;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
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
