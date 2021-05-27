package services;

import java.sql.Connection;

import database.DBConnection;

public abstract class BaseService {
	protected DBConnection dbc;
	protected Connection conn;

	public BaseService(DBConnection dbc) {
		this.dbc = dbc;
	}

	public void connect() throws Exception {
		if (this.conn == null || this.conn.isClosed()) {
			this.conn = dbc.getConnection();
		}
	}

	public void disconnect() throws Exception {
		if (this.conn != null && !this.conn.isClosed()) {
			this.conn.close();
		}
	}
}
