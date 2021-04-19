import java.sql.*;

class HelloWordl {
	public static void main(String args[]) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/do_an_1", "long", "tnt");
//here sonoo is database name, root is username and password  
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select cat_id from db_category");
			while (rs.next())
				System.out.println(rs.getInt(1));
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}