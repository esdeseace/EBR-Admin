package beans;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedHashMap;

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
	private String licensePlate;
	private Timestamp manuDate;
	private Timestamp rentedDate;
	private Timestamp returnDate;
	private String producer;
	private int cost;
	private int status;
	
	public Bike() {
		super();
	}

	public static LinkedHashMap<String, String> getFields() {
		LinkedHashMap<String, String> fields = new LinkedHashMap<String, String>();
		fields.put("id", "id");
		fields.put("name", "Tên xe");
		fields.put("type", "Loại xe");
		fields.put("weight", "Cân nặng");
		fields.put("license_plate", "Biển số");
		fields.put("manu_date", "Ngày sản xuất");
		fields.put("producer", "Nhà sản xuất");
		fields.put("cost", "Giá");
		fields.put("status", "Trạng thái");
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

	public static ArrayList<FieldOption> getUpdateFields() {
		ArrayList<FieldOption> fields = new ArrayList<>();
		fields.add(new FieldOption("id", "id", false, false));
		fields.add(new FieldOption("name", "Tên xe"));
		fields.add(new FieldOption("type", "Loại xe"));
		fields.add(new FieldOption("weight", "Cân nặng"));
		fields.add(new FieldOption("license_plate", "Biển số"));
		fields.add(new FieldOption("manu_date", "Ngày sản xuất"));
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
		fields.add(new FieldOption("license_plate", "Biển số"));
		fields.add(new FieldOption("manu_date", "Ngày sản xuất"));
		fields.add(new FieldOption("producer", "Nhà sản xuất"));
		fields.add(new FieldOption("cost", "Giá"));
		fields.add(new FieldOption("status", "Trạng thái"));
		return fields;
	}
	




}
