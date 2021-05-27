package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class MySQLConnect {
	private String url;
	private Properties properties;

	public MySQLConnect(String host, String port, String dbName, String user, String password) {
		this.url = "jdbc:mysql://" + host + ":" + port + "/" + dbName;

		this.properties = new Properties();
		this.properties.setProperty("user", user);
		this.properties.setProperty("password", password);
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(this.url, this.properties);
	}

	public static void main(String[] args) {
		MySQLConnect db = new MySQLConnect("localhost", "3306", "exercises_2", "long", "tnt");
		Connection a = null;
		try {
			if(a == null || a.isClosed()) {
				System.out.println("ok");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = db.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("select * from class");) {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(1) + ":" + rs.getString("class_name"));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
