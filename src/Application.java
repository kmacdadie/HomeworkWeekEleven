import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		//jdbc:mysql://hostname:port/databasename
		String connectionString = "jdbc:mysql://localhost:3306/employees"; //localhost is an alias to 12.0.0.1, this is my actual computer
		final String SELECT_QUERY = "SELECT * FROM employees where emp_no = ?";
		
		Scanner scanner = new Scanner(System.in);
		
		try {
			Connection conn = DriverManager.getConnection(connectionString, "root", "root"); 
			System.out.println("Connected successfully!");
			System.out.println("Enter employee number: ");
			String empNo = scanner.nextLine();
			PreparedStatement ps = conn.prepareStatement(SELECT_QUERY);
			ps.setString(1, empNo);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				System.out.println("emp_no: " + rs.getInt(1) + " dob: " + rs.getString(2) + " first name: " + rs.getString(3));
			}
		} catch (SQLException e) {
			System.out.println("Error connection to the database.");
			e.printStackTrace();
		}
	}
	
}
