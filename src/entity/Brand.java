package entity;

import java.util.List;

public class Brand {
	
	private int brandId;
	private String brand;
	private List<Truck_size> truck_size;
	
	public Brand(int brandId, String brand, List<Truck_size> truck_size) {
		this.setBrandId(brandId);
		this.setBrand(brand);
		this.setTruck_size(truck_size);
		
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public List<Truck_size> getTruck_size() {
		return truck_size;
	}

	public void setTruck_size(List<Truck_size> truck_size) {
		this.truck_size = truck_size;
	}
	
	
}
