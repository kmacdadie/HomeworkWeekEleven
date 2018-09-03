package entity;

public class Truck_size {

	private int truck_sizeId;
	private String size;
	private String gas_type;
	
	public Truck_size(int truck_sizeId, String size, String gas_type) {
		this.setTruck_sizeId(truck_sizeId);
		this.setSize(size);
		this.setGas_type(gas_type);
	}

	public int getTruck_sizeId() {
		return truck_sizeId;
	}

	public void setTruck_sizeId(int truck_sizeId) {
		this.truck_sizeId = truck_sizeId;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getGas_type() {
		return gas_type;
	}

	public void setGas_type(String gas_type) {
		this.gas_type = gas_type;
	}
	
	
}
	