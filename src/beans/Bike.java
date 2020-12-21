package beans;

import java.sql.Time;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.fasterxml.jackson.annotation.JsonTypeName;

import helpers.FieldOption;

@JsonTypeName("bike")
public class Bike {
	
	private String id;
	private String name;
	private String idPark;
	private String idUser;
	private String type;
	private int weight;
	private String license_plate;
	private String manu_date;
	private String rented_date;
	private String return_date;
	private String producer;
	private int cost;
	private int status;
	private String created_at;
	private String updated_at;
	
	public Bike() {
		super();
	}
	public Bike(String id, String name, String type, int weight, String license_plate, String manu_date,
			String rented_date, String return_date, String producer, int cost, int status, String created_at,
			String updated_at) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.weight = weight;
		this.license_plate = license_plate;
		this.manu_date = manu_date;
		this.rented_date = rented_date;
		this.return_date = return_date;
		this.producer = producer;
		this.cost = cost;
		this.status = status;
		this.created_at = created_at;
		this.updated_at = updated_at;
		
	}

	public static LinkedHashMap<String, String> getFields() {
		LinkedHashMap<String, String> fields = new LinkedHashMap<String, String>();
		fields.put("id", "id");
		fields.put("name", "Tên xe");
		fields.put("type", "Loại xe");
		fields.put("weight", "Cân nặng");
		fields.put("license_plate", "Biển số");
		fields.put("manu_date", "Ngày sản xuất");
//		fields.put("rented_date", "Ngày thuê");
//		fields.put("return_date", "Ngày trả");
		fields.put("producer", "Nhà sản xuất");
		fields.put("cost", "Giá");
		fields.put("status", "Trạng thái");
//		fields.put("created_at", "created");
//		fields.put("updated_at", "updated");
		return fields;
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
//		fields.add(new FieldOption("idPark", "id bãi xe"));
//		fields.add(new FieldOption("idUser", "id người dùng"));
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
//		fields.add(new FieldOption("", "id bãi xe"));
//		fields.add(new FieldOption("", "id người dùng"));
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

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getLicense_plate() {
		return license_plate;
	}
	public void setLicense_plate(String license_plate) {
		this.license_plate = license_plate;
	}
	public String getManu_date() {
		return manu_date;
	}
	public void setManu_date(String manu_date) {
		this.manu_date = manu_date;
	}
	public String getRented_date() {
		return rented_date;
	}
	public void setRented_date(String rented_date) {
		this.rented_date = rented_date;
	}
	public String getReturn_date() {
		return return_date;
	}
	public void setReturn_date(String return_date) {
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
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

}
