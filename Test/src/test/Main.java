package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {
	public static Object createObject() throws Exception {
		Class<?> cls = Class.forName("test.People");
		People p = (People) cls.getDeclaredConstructor().newInstance();
		System.out.println(p.toString());
		return p;
	}

	public static void main(String[] args) {
//		try {
//			Object a = createObject();
//			System.out.println(a.toString());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_java", "long", "tnt");
			PreparedStatement stmt = con.prepareStatement("select * from db_class");
			ResultSet rs = stmt.executeQuery();
			System.out.println(rs.getMetaData().getColumnCount());
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
