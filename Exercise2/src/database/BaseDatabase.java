package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class BaseDatabase {
	private final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private String host = null;
	private String port = null;
	private String dbName = null;
	private String userName = null;
	private String passWord = null;
	private String url = null;
	private Connection connect = null;
	private ResultSet rs = null;
	private PreparedStatement stmt = null;

	// constructor: set attribute and start connect
	public BaseDatabase(String host, String port, String dbName, String userName, String passWord) {
		this.host = host;
		this.port = port;
		this.dbName = dbName;
		this.userName = userName;
		this.passWord = passWord;
		this.createUrl();

		try {
			this.open();
			System.out.println("ok");
		} catch (Exception e) {
			System.out.println("error when connection");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	// open connect
	private void open() throws Exception {
		Class.forName(this.DRIVER);
		this.connect = DriverManager.getConnection(this.url, this.userName, this.passWord);
	}

	// create URL
	private void createUrl() {
		this.url = "jdbc:mysql://" + this.host + ":" + this.port + "/" + this.dbName;
	}

	// execute SQL query
	public ResultSet query(String sql, Object[] param) {
		try {
			this.stmt = this.connect.prepareStatement(sql);

			if (param != null) {
				for (int i = 0; i < param.length; ++i) {
					this.stmt.setObject(i + 1, param[i]);
				}
			}

			if (this.stmt.execute()) {
				this.rs = this.stmt.getResultSet();
			} else {
				this.rs = null;
			}
		} catch (Exception e) {
			System.out.println("error when execute query");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return this.rs;

	}

	// close connect
	public void close() {
		if (this.rs != null) {
			try {
				this.rs.close();
			} catch (Exception e) {

			}
			this.rs = null;
		}

		if (this.stmt != null) {
			try {
				this.stmt.close();
			} catch (Exception e) {

			}
			this.stmt = null;
		}

		if (this.connect != null) {
			try {
				this.connect.close();
			} catch (Exception e) {

			}
			this.connect = null;
		}
	}

	// get result
	public ResultSet getResult() {
		return this.rs;
	}

}
