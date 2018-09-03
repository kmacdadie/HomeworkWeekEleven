package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.BrandDao;
import dao.Truck_sizeDao;
import entity.Brand;
import entity.Truck_size;

public class Menu {
	
	private BrandDao brandDao = new BrandDao();
	private Truck_sizeDao truck_sizeDao = new Truck_sizeDao(); 
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"Display Brands",
			"Display a Brand", 
			"Create Brand", 
			"Delete Brand",
			"Update Brand",
			"Create Truck_size",
			"Delete Truck_size",
			"Update Truck_size");
	
	public void start() {
		String selection = "";
		
		do {
			printMenu();
			selection = scanner.nextLine();
			
			try {
				if (selection.equals("1")) {
					displayBrands();
				} else if (selection.equals("2")) {
					displayBrand();
				} else if (selection.equals("3")) {
					createBrand();
				} else if (selection.equals("4")) {
					deleteBrand();
				} else if (selection.equals("5")) {
					createTruck_size();
				} else if (selection.equals("6")) {
					deleteTruck_size();
				} else if (selection.equals("7")) {
					updateTruck_size();
				} else if (selection.equals("8")) {
					updateBrand(); 	
					}
				} catch (SQLException e) {
				e.printStackTrace();
			}
			
			System.out.println("Press enter to continue..");
			scanner.nextLine();			
		} while(!selection.equals("-1"));
	}
	
	private void printMenu() {
		System.out.println("Select an Option:\n-----------------------------");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ") " + options.get(i));
			
		}
	}
	
	private void displayBrands() throws SQLException {
		List<Brand> brands = brandDao.getBrands();
		for (Brand brand : brands) {
			System.out.println(brand.getBrandId() + ": " + brand.getBrand());
		}
	} 
	
	private void displayBrand() throws SQLException {
		System.out.print("Enter Brand id:");
		int id = Integer.parseInt(scanner.nextLine());
		Brand brand = brandDao.getBrandById(id);
		System.out.println(brand.getBrandId() + ": " + brand.getBrand());
		for (Truck_size truck_size : brand.getTruck_size()) {
			System.out.println("\tTruck_sizeId: " + truck_size.getTruck_sizeId() + " - Brand: " + truck_size.getSize() + " " + truck_size.getGas_type());
		}
	}
	
	private void createBrand() throws SQLException {
		System.out.print("Enter new brand name");
		String brandName = scanner.nextLine();
		brandDao.createNewBrand(brandName);
	}
	
	private void deleteBrand() throws SQLException {
		System.out.print("Enter team id to delete:");
		int id = Integer.parseInt(scanner.nextLine());
		brandDao.deleteBrandById(id);
	}
	
	private void createTruck_size() throws SQLException {
		System.out.print("Enter Brand of new truck:");
		String brand = scanner.nextLine();
		System.out.print("Enter gas_type of new truck:");
		String gas_type = scanner.nextLine();
		System.out.print("Enter brand Id of new truck:");
		int brandId = Integer.parseInt(scanner.nextLine());
		truck_sizeDao.createNewTruck_size(brand, gas_type, brandId);
	}
	
	private void deleteTruck_size() throws SQLException {
		System.out.print("Enter truck_size id to delete:");
		int id = Integer.parseInt(scanner.nextLine());
		truck_sizeDao.deleteTruck_sizeById(id);
	}
	
	private void updateTruck_size() throws SQLException {
		System.out.print("Enter Brand of new truck:");
		String brand = scanner.nextLine();
		System.out.print("Enter gas_type of new truck:");
		String gas_type = scanner.nextLine();
		System.out.print("Enter brand Id of new truck:");
		int brandId = Integer.parseInt(scanner.nextLine());
		truck_sizeDao.updateTruck_sizeById(brand, gas_type, brandId);
	}
	
	private void updateBrand() throws SQLException {
		System.out.print("Enter new brand name");
		String brandName = scanner.nextLine();
		brandDao.updateBrand(brandName);
	}
}
