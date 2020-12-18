package beans;

import java.sql.Time;
import java.util.LinkedHashMap;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("bike")
public class Bike {

	private String id;
	private String name;
	private String idPark;
	private String idUser;
	private String type;
	private float weight;
	private String licensePlate;
	private Time manuDate;
	private Time rentedDate;
	private Time returnDate;
	private String producer;
	private int cost;
	private String status;

	public Bike(String id, String name, String type, float weight, String licensePlate, Time manuDate, Time rentedDate,
			Time returnDate, String producer, int cost) {
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
		fields.put("cost", "Giá xe");

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

	public String getIdPark() {
		return idPark;
	}

	public void setIdPark(String idPark) {
		this.idPark = idPark;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public Time getManuDate() {
		return manuDate;
	}

	public void setManuDate(Time manuDate) {
		this.manuDate = manuDate;
	}

	public Time getRentedDate() {
		return rentedDate;
	}

	public void setRentedDate(Time rentedDate) {
		this.rentedDate = rentedDate;
	}

	public Time getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Time returnDate) {
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
