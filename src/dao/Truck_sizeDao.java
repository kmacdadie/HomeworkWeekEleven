package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Truck_size;

public class Truck_sizeDao {
	
	private Connection connection;
	private final String GET_TRUCK_SIZE_BY_BRAND_ID_QUERY = "SELECT * FROM truck_sizes WHERE brand_id = ?";
	private final String DELETE_TRUCK_SIZE_BY_BRAND_ID_QUERY = "DELETE FROM truck_sizes WHERE brand_id = ?";
	private final String CREATE_NEW_TRUCK_SIZE_QUERY = "INSERT INTO truck_size(brand, gas_type, brand_id) VALUES(?,?,?)";
	private final String DELETE_TRUCK_SIZE_BY_ID_QUERY = " DELETE FROM truck_size WHERE id = ?";
	private final String UPDATE_TRUCK_SIZE_ID_QUERY = "UPDATE FROM truck_size WHERE id = ?";
	
	public Truck_sizeDao() {
		connection = DBConnection.getConnection();
	}

	public List<Truck_size> getTruck_sizeByBrandId(int brandId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_TRUCK_SIZE_BY_BRAND_ID_QUERY);
		ps.setInt(1, brandId);
		ResultSet rs = ps.executeQuery();
		List<Truck_size> truck_sizes = new ArrayList<Truck_size>();
		
		while (rs.next()) {
			truck_sizes.add(new Truck_size(rs.getInt(1), rs.getString(2), rs.getString(3)));
		}
		
		return null;
	}
	
	public void createNewTruck_size(String brand, String gas_type, int brandId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_TRUCK_SIZE_QUERY);
		ps.setString(1, brand);
		ps.setString(2, gas_type);
		ps.setInt(3, brandId);
		ps.executeUpdate();
				
	}
	
	public void deleteTruck_sizesByBrandId(int brandId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_TRUCK_SIZE_BY_BRAND_ID_QUERY);
		ps.setInt(1, brandId);
		ps.executeUpdate();
	}
	
	public void deleteTruck_sizeById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_TRUCK_SIZE_BY_ID_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
	public void updateTruck_sizeById(String brand, String gas_type, int brandId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_TRUCK_SIZE_ID_QUERY);
		ps.setInt(1, brandId);
		ps.setString(1, brand);
		ps.setString(2, gas_type);
		ps.executeUpdate();
	}

		

}
 