package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Brand;

public class BrandDao {
	
	private Connection connection;
	private Truck_sizeDao truck_sizeDao;
	private final String GET_BRANDS_QUERY = "SELECT * FROM  trucks";
	private final String GET_BRAND_BY_ID_QUERY = "SELECT * FROM brands WHERE id = ?";
	private final String CREATE_NEW_BRAND_QUERY = "INSERT INTO brands(brand) VALUES(?)";
	private final String DELETE_BRAND_BY_ID_QUERY = "DELETE FROM brands WHERE id = ?";
	private final String UPDATE_BRAND_BY_ID_QUERY = "UPDATE FROM brands WHERE id = ?";
	
	public BrandDao() {
		connection = DBConnection.getConnection();
		truck_sizeDao = new Truck_sizeDao();
	}
	
	public List<Brand> getBrands() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_BRANDS_QUERY).executeQuery();
		List<Brand> brands = new ArrayList<Brand>();
		
		while (rs.next()) {
			brands.add(populateBrand(rs.getInt(1), rs.getString(2)));
			
		}
		
		return brands;
		
	}
	
	public Brand getBrandById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_BRAND_BY_ID_QUERY);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return populateBrand(rs.getInt(1), rs.getString(2));
	}
	
	public void createNewBrand(String brandName) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_BRAND_QUERY);
		ps.setString(1, brandName);
		ps.executeUpdate();
	}
	
	public void deleteBrandById(int id) throws SQLException {
		truck_sizeDao.deleteTruck_sizesByBrandId(id);
		PreparedStatement ps = connection.prepareStatement(DELETE_BRAND_BY_ID_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
	public void updateBrand(String brandName) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_BRAND_BY_ID_QUERY);
		ps.setString(1, brandName);
		ps.executeQuery();
				
	}
	
	private Brand populateBrand(int id, String brand) throws SQLException {
		return new Brand(id, brand, truck_sizeDao.getTruck_sizeByBrandId(id));
					
	}
	
}
