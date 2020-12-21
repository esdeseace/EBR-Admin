package beans;
import java.util.LinkedHashMap;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("park")
public class Park {
	private String id; // id bãi xe
	private String parkName; // Tên bãi xe
	private String address; // Địa chỉ
	private int capacity; // Sức chứa của xe trong bãi 
	private int numBikes; // Số lượng xe loại Bikes
	private int numEBikes; // Số lượng xe loại EBikes
	private int numTwinBike;// Số lượng xe loại TwinBikes
	private int numRentedBike;  // Số lượng xe loại Bikes đã thuê
	private int numRentedEBike;// Số lượng xe loại EBikes đã thuê
	private int numRentedTwinBike;// Số lượng xe loại TwinBikes đã thuê
	
	public Park() {
		super();
	}
	
	public Park(String id, String parkName, String address, int capacity, int numBikes, int numEBikes,
			int numTwinBike) {
		
		this.id = id;
		this.parkName = parkName;
		this.address = address;
		this.capacity = capacity;
		this.numBikes = numBikes;
		this.numEBikes = numEBikes;
		this.numTwinBike = numTwinBike;
		
	}
	
	
	
	public Park(String id, String parkName, String address, int capacity, int numBikes, int numEBikes, int numTwinBike,
			int numRentedBike, int numRentedEBike, int numRentedTwinBike) {
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

	public String getParkName() {
		return parkName;
	}
	public void setParkName(String parkName) {
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
