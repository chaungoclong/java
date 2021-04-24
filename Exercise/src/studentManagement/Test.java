package studentManagement;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Test {

	public static void main(String[] args) {
		Database a = new Database("localhost", "3306", "long", "tnt", "student_java");
		ArrayList<HashMap<String, String>> rs = a.query("select * from db_student").getResult();
		for (HashMap<String, String> hashMap : rs) {
			System.out.println(hashMap.get("stu_id"));
		}
		
		a.checkStatus();

		a.query("select * from db_student").getResult();
		
		a.checkStatus();
		
		a.query("update db_class set cls_name = 'aaa' where cls_id = 1");
		
		a.checkStatus();

	}

}
