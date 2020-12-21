package beans;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import helpers.FieldOption;

@JsonTypeName("park")
public class Park {
	private String id; // id bãi xe

	@JsonProperty("park_name")
	private String parkName; // Tên bãi xe

	private String address; // Địa chỉ

	private int capacity; // Sức chứa của xe trong bãi

	@JsonProperty("num_bikes")
	private int numBikes; // Số lượng xe loại Bikes

	@JsonProperty("num_e_bikes")
	private int numEBikes; // Số lượng xe loại EBikes

	@JsonProperty("num_twin_bike")
	private int numTwinBike;// Số lượng xe loại TwinBikes

	@JsonProperty("num_rented_bike")
	private int numRentedBike; // Số lượng xe loại Bikes đã thuê

	@JsonProperty("num_rented_e_bike")
	private int numRentedEBike;// Số lượng xe loại EBikes đã thuê

	@JsonProperty("num_rented_twin_bike")
	private int numRentedTwinBike;// Số lượng xe loại TwinBikes đã thuê

	@JsonProperty("created_at")
	private Timestamp createdAt;

	@JsonProperty("updated_at")
	private Timestamp updatedAt;

	public Park() {
		super();
	}

	public Park(String id, String parkName, String address, int capacity, int numBikes, int numEBikes, int numTwinBike,
			int numRentedBike, int numRentedEBike, int numRentedTwinBike, Timestamp createdAt, Timestamp updatedAt) {
		super();
		this.id = id;
		this.parkName = parkName;
		this.address = address;
		this.capacity = capacity;
		this.numBikes = numBikes;
		this.numEBikes = numEBikes;
		this.numTwinBike = numTwinBike;
		this.numRentedBike = numRentedBike;
		this.numRentedEBike = numRentedEBike;
		this.numRentedTwinBike = numRentedTwinBike;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public static LinkedHashMap<String, String> getFields() {
		LinkedHashMap<String, String> fields = new LinkedHashMap<String, String>();
		fields.put("id", "id");
		fields.put("parkName", "Tên bãi xe");
		fields.put("address", "Địa chỉ");
		fields.put("capacity", "Tổng số xe");
		fields.put("numBikes", "Số xe Bikes");
		fields.put("numEBikes", "Số xe EBikes");
		fields.put("numTwinBike", "Số xe TwinBikes");
		return fields;
	}

	public static ArrayList<FieldOption> getUpdateFields() {
		ArrayList<FieldOption> fields = new ArrayList<>();
		fields.add(new FieldOption("id", "id", false, false));
		fields.add(new FieldOption("parkName", "Tên bãi xe"));
		fields.add(new FieldOption("address", "Địa chỉ"));
		fields.add(new FieldOption("capacity", "Tổng số xe"));
		fields.add(new FieldOption("numBikes", "Số xe Bikes"));
		fields.add(new FieldOption("numEBikes", "Số xe EBikes"));
		fields.add(new FieldOption("numTwinBike", "Số xe TwinBikes"));
		return fields;
	}

	public static ArrayList<FieldOption> getCreateFields() {
		ArrayList<FieldOption> fields = new ArrayList<>();
//		fields.add(new FieldOption("id", "id", false, false))
		fields.add(new FieldOption("park_name", "Tên bãi xe"));
		fields.add(new FieldOption("address", "Địa chỉ"));
		fields.add(new FieldOption("capacity", "Tổng số xe"));
		fields.add(new FieldOption("numBikes", "Số xe Bikes"));
		fields.add(new FieldOption("numEBikes", "Số xe EBikes"));
		fields.add(new FieldOption("numTwinBike", "Số xe TwinBikes"));

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

	public String getparkName() {
		return parkName;
	}

	public void setparkName(String parkName) {
		this.parkName = parkName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getNumBikes() {
		return numBikes;
	}

	public void setNumBikes(int numBikes) {
		this.numBikes = numBikes;
	}

	public int getNumEBikes() {
		return numEBikes;
	}

	public void setNumEBikes(int numEBikes) {
		this.numEBikes = numEBikes;
	}

	public int getNumTwinBike() {
		return numTwinBike;
	}

	public void setNumTwinBike(int numTwinBike) {
		this.numTwinBike = numTwinBike;
	}

	public int getNumRentedBike() {
		return numRentedBike;
	}

	public void setNumRentedBike(int numRentedBike) {
		this.numRentedBike = numRentedBike;
	}

	public int getNumRentedEBike() {
		return numRentedEBike;
	}

	public void setNumRentedEBike(int numRentedEBike) {
		this.numRentedEBike = numRentedEBike;
	}

	public int getNumRentedTwinBike() {
		return numRentedTwinBike;
	}

	public void setNumRentedTwinBike(int numRentedTwinBike) {
		this.numRentedTwinBike = numRentedTwinBike;
	}

	@Override
	public String toString() {
		return "Park [id=" + id + ", parkName=" + parkName + ", address=" + address + ", capacity=" + capacity
				+ ", numBikes=" + numBikes + ", numEBikes=" + numEBikes + ", numTwinBike=" + numTwinBike
				+ ", numRentedBike=" + numRentedBike + ", numRentedEBike=" + numRentedEBike + ", numRentedTwinBike="
				+ numRentedTwinBike + "]";
	}

}