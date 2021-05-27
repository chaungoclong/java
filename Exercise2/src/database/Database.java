package database;

import java.sql.ResultSet;

public class Database extends BaseDatabase {
	public Database(String host, String port, String dbName, String userName, String passWord) {
		super(host, port, dbName, userName, passWord);
	}

	public static void main(String[] args) {
		Database db = new Database("localhost", "3306", "student_java", "long", "tnt");
		Object[] param = { 10 };
		ResultSet rs = db.query("select * from db_class where cls_id = ?", param);

		try {
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			rs = null;
		}

	}
}
