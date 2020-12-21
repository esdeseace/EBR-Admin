package beans;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import helpers.FieldOption;

@JsonTypeName("bike")
public class Bike {

	private String id;
	private String name;

	private Park park;
	private User user;

	private String type;
	private int weight;

	@JsonProperty("license_plate")
	private String licensePlate;

	@JsonProperty("manu_date")
	private Timestamp manuDate;

	@JsonProperty("rented_date")
	private Timestamp rentedDate;

	@JsonProperty("return_date")
	private Timestamp returnDate;
	private String producer;
	private int cost;
	private int status;

	@JsonProperty("created_at")
	private Timestamp createdAt;

	@JsonProperty("updated_at")
	private Timestamp updatedAt;

	public Bike() {
		super();
	}

	public Bike(String id, String name, String type, int weight, String licensePlate, Timestamp manuDate,
			Timestamp rentedDate, Timestamp returnDate, String producer, int cost, int status, Timestamp createdAt,
			Timestamp updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.weight = weight;
		this.licensePlate = licensePlate;
		this.manuDate = manuDate;
		this.rentedDate = rentedDate;
		this.returnDate = returnDate;
		this.producer = producer;
		this.cost = cost;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Bike(String id, String name, Park park, User user, String type, int weight, String licensePlate,
			Timestamp manuDate, Timestamp rentedDate, Timestamp returnDate, String producer, int cost, int status,
			Timestamp createdAt, Timestamp updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.park = park;
		this.user = user;
		this.type = type;
		this.weight = weight;
		this.licensePlate = licensePlate;
		this.manuDate = manuDate;
		this.rentedDate = rentedDate;
		this.returnDate = returnDate;
		this.producer = producer;
		this.cost = cost;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public static LinkedHashMap<String, String> getFields() {
		LinkedHashMap<String, String> fields = new LinkedHashMap<String, String>();
		fields.put("id", "id");
		fields.put("name", "Tên xe");
		fields.put("type", "Loại xe");
		fields.put("weight", "Cân nặng");
		fields.put("licensePlate", "Biển số");
		fields.put("manuDate", "Ngày sản xuất");
		fields.put("producer", "Nhà sản xuất");
		fields.put("cost", "Giá");
		fields.put("status", "Trạng thái");
		return fields;
	}

	public static ArrayList<FieldOption> getUpdateFields() {
		ArrayList<FieldOption> fields = new ArrayList<>();
		fields.add(new FieldOption("id", "id", false, false));
		fields.add(new FieldOption("name", "Tên xe"));
		fields.add(new FieldOption("type", "Loại xe"));
		fields.add(new FieldOption("weight", "Cân nặng"));
		fields.add(new FieldOption("licensePlate", "Biển số"));
		fields.add(new FieldOption("manuDate", "Ngày sản xuất"));
		fields.add(new FieldOption("producer", "Nhà sản xuất"));
		fields.add(new FieldOption("cost", "Giá"));
		fields.add(new FieldOption("status", "Trạng thái"));
		return fields;
	}

	public static ArrayList<FieldOption> getCreateFields() {
		ArrayList<FieldOption> fields = new ArrayList<>();
		fields.add(new FieldOption("id", "id", false, false));
		fields.add(new FieldOption("name", "Tên xe"));
		fields.add(new FieldOption("type", "Loại xe"));
		fields.add(new FieldOption("weight", "Cân nặng"));
		fields.add(new FieldOption("licensePlate", "Biển số"));
		fields.add(new FieldOption("manuDate", "Ngày sản xuất"));
		fields.add(new FieldOption("producer", "Nhà sản xuất"));
		fields.add(new FieldOption("cost", "Giá"));
		fields.add(new FieldOption("status", "Trạng thái"));
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

	public Park getPark() {
		return park;
	}

	public void setPark(Park park) {
		this.park = park;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public Timestamp getManuDate() {
		return manuDate;
	}

	public void setManuDate(Timestamp manuDate) {
		this.manuDate = manuDate;
	}

	public Timestamp getRentedDate() {
		return rentedDate;
	}

	public void setRentedDate(Timestamp rentedDate) {
		this.rentedDate = rentedDate;
	}

	public Timestamp getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Timestamp returnDate) {
		this.returnDate = returnDate;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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

}