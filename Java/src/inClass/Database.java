package inClass;

import java.util.*;
import java.sql.*;

public class Database {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private String URL = null;
	private String domain = null;
	private String port = null;
	private String databaseName = null;
	private String user = null;
	private String pass = null;
	private Connection connect = null;
	private Statement stmt = null;
	private ArrayList<HashMap<String, String>> result = null;

	// constructor
	public Database(String domain, String port, String user, String pass, String databaseName) {
		this.domain = domain;
		this.port = port;
		this.user = user;
		this.pass = pass;
		this.databaseName = databaseName;
		this.URL = "jdbc:mysql://" + this.domain + ":" + this.port + "/" + this.databaseName;
		// System.out.println(this.URL);
	}

	// open connect
	public void openConnect() throws Exception, SQLException {
		if (this.connect == null) {
			Class.forName(DRIVER);
			this.connect = DriverManager.getConnection(URL, this.user, this.pass);
			this.stmt = this.connect.createStatement();
		}
	}

	// close connect
	public void closeConnect() throws Exception, SQLException {
		if (this.stmt != null) {
			this.stmt.close();
		}

		if (this.connect != null) {
			this.connect.close();
		}
	}

	// run query (insert, update, delete)
	public boolean run(String sql) {
		try {
			this.openConnect();
			this.stmt.execute(sql);
			this.closeConnect();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	// get result
	public ArrayList<HashMap<String, String>> get(String sql) {
		this.result = new ArrayList<HashMap<String, String>>();
		try {
			// start connect
			this.openConnect();

			// get data
			ResultSet rs = this.stmt.executeQuery(sql);
			
			// get number of column (index of column start from 1)
			int numCol = rs.getMetaData().getColumnCount();

			// this will read each row in data until the end (like for each or use fetch_array , fetch assoc in while loop in PHP)
			while (rs.next()) {
				// creat row
				HashMap<String, String> row = new HashMap<String, String>();
				for (int i = 0; i < numCol; i++) {
					row.put(rs.getMetaData().getColumnName(i + 1), rs.getString(i + 1));
				}
				
				// add row to result
				this.result.add(row);
			}

			// end connect
			this.closeConnect();
		} catch (Exception e) {
			// If an exception occurs set value of result to null then show exception
			this.result = null;
			System.out.println(e.getMessage());
		}

		// return result
		return this.result;
	}

	public String getURL() {
		return this.URL;
	}

	public void setURL(String URL) {
		this.URL = URL;
	}

	public void changeURL() {
		this.URL = "jdbc:mysql://" + this.domain + ":" + this.port + "/" + this.databaseName;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getDatabaseName() {
		return databaseName;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
		this.changeURL();
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Connection getConnect() {
		return connect;
	}

	public void setConnect(Connection connect) {
		this.connect = connect;
	}

	public Statement getStmt() {
		return stmt;
	}

	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}

}
