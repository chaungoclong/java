package studentManagement;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Database {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private String URL = null;
	private String domain = null;
	private String port = null;
	private String user = null;
	private String pass = null;
	private String dbName = null;
	private Connection connect = null;
	private Statement stmt = null;
	private ResultSet result = null;
	private ArrayList<HashMap<String, String>> resultTbl;

	public Database(String domain, String port, String user, String pass, String dbName) {
		this.domain = domain;
		this.port = port;
		this.user = user;
		this.pass = pass;
		this.dbName = dbName;
		this.setURL();

		try {
			this.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// open
	public void open() throws Exception, SQLException {
		if (this.connect == null) {
			Class.forName(DRIVER);
			this.connect = DriverManager.getConnection(this.URL, user, pass);
			this.stmt = this.connect.createStatement();
			System.out.println("connect success");
		}
	}

	// close
	public void close() {
		if (this.result != null) {
			try {
				this.result.close();
			} catch (SQLException e) {

			}
			this.result = null;
		}

		if (this.stmt != null) {
			try {
				this.stmt.close();
			} catch (SQLException e) {

			}
			this.stmt = null;
		}

		if (this.connect != null) {
			try {
				this.connect.close();
			} catch (SQLException e) {

			}
			this.connect = null;
		}
	}

	// run
	public Database query(String sql) {
		try {
			//this.open();
			if (this.stmt.execute(sql)) {
				this.result = this.stmt.getResultSet();
				this.resultTbl = new ArrayList<HashMap<String, String>>();

				// get number of column (index of column start from 1)
				int numCol = this.result.getMetaData().getColumnCount();

				// this will read each row in data until the end (like for each or use
				// fetch_array , fetch assoc in while loop in PHP)
				while (this.result.next()) {
					// creat row
					HashMap<String, String> row = new HashMap<String, String>();
					for (int i = 0; i < numCol; i++) {
						row.put(this.result.getMetaData().getColumnName(i + 1), this.result.getString(i + 1));
					}

					// add row to result
					this.resultTbl.add(row);
				}

			}
			//this.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	// get

	public Connection getConnect() {
		return this.connect;
	}

	public Statement getStmt() {
		return this.stmt;
	}

	public ArrayList<HashMap<String, String>> getResult() {
		return this.resultTbl;
	}

	public void setURL() {
		this.URL = "jdbc:mysql://" + this.domain + ":" + this.port + "/" + this.dbName;
		
	}

	public void checkStatus() {
		if (this.connect != null) {
			System.out.println("connected");
		} else {
			System.out.println("disconnected");
		}
	}
}
