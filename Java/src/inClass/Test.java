package inClass;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Test {

	public static void main(String[] args) throws SQLException {
		Database a = new Database("localhost", "3306", "long", "tnt", "student_java");
//		String sql = "insert into student(stu_name, stu_c, stu_php, stu_avg, stu_rank) values('abcdefg', 10, 10, 10, 'ok')";
//		// insert
//		if(a.run(sql)) {
//			System.out.println("success");
//		} else {
//			System.out.println("fail");
//		}
		
		//get
		String sql = "select * from student";
		ArrayList<HashMap<String, String>> x = a.get(sql);
		for (HashMap<String, String> hashMap : x) {
			System.out.println(hashMap.get("stu_id") + "|" + hashMap.get("stu_name"));
		}
		//System.out.println(x);
		//a.get(sql);
		
	}

}
