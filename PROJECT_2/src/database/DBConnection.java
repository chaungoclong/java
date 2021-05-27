package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {
	private static final String DB_HOST = "localhost";
	private static final String DB_PORT = "3306";
	private static final String DB_DATABASE = "exercises_2";
	private static final String DB_USER = "long";
	private static final String DB_PASSWORD = "tnt";
	private static final String DB_URL = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_DATABASE;

	private static Connection connection;
	private static DBConnection instance = new DBConnection();

	private DBConnection() {
	}

	public static DBConnection getInstance() {
		return instance;
	}

	public Connection getConnection() throws Exception {
		if (connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		}
		return connection;
	}

	public static void main(String[] args) {
		DBConnection db = DBConnection.getInstance();
		Connection conn;
		try {
			conn = db.getConnection();
			PreparedStatement stmt = conn.prepareStatement("select * from class");
			ResultSet rs = stmt.executeQuery();
			System.out.println(rs.getMetaData());
			while (rs.next()) {
				System.out.println(rs.getString(1) + ":" + rs.getString("class_name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
