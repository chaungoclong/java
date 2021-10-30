package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Connector {
	private static final String URL = "jdbc:mysql://localhost:3306/java_project";
	private static final String USERNAME = "long";
	private static final String PASSWORD = "tnt";
	// private static Connection connection;

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("connector:");
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) {
		Connection conn = Connector.getConnection();

		try {
			PreparedStatement pstmt = conn.prepareStatement("select * from products");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString("name") + "-" + rs.getInt("price"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
