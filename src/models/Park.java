package models;

public class Park {
	private String id; // id bãi xe
	private String parkName; // Tên bãi xe
	private String address; // Địa chỉ
	private int capacity; // Sức chứa bãi xe
	private int numBikes; // Số lượng xe loại Bikes
	private int numEBikes;// Số lượng xe loại EBikes
	private int numTwinBike;// Số lượng xe loại TwinBikes
	private int numRentedBike; // Số lượng xe loại Bikes đã thuê
	private int numRentedEBike;// Số lượng xe loại EBikes đã thuê
	private int numRentedTwinBike;// Số lượng xe loại TwinBikes đã thuê
	
	
	
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getParkName() {
		return parkName;
	}
	public void setParkName(String parkName) {
		this.parkName = parkName;
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
	
	
	
	
	
}
