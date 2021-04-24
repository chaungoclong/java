package studentManagement;

//import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class Classroom {
	private int classId;
	private int idForUpdate;
	private String className;
	private Database conn = new Database("localhost", "3306", "long", "tnt", "student_java");
//	private Scanner in = new Scanner(System.in);

	public Classroom() {

	}

	public Classroom(int classId, String className) {
		super();
		this.classId = classId;
		this.className = className;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}
	
	public void setIdForUpdate(int idForUpdate) {
		this.idForUpdate = idForUpdate;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public void add() {
		try {
			String sql = "insert into db_class(cls_name) values('" + this.className + "')";
			this.conn.query(sql);
			System.out.println("add success\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void show() {
		System.out.println("___LIST OF CLASS___\n");
		String sql = "select * from db_class";
		ArrayList<HashMap<String, String>> rs = this.conn.query(sql).getResult();
		for (HashMap<String, String> eachClass : rs) {
			System.out.println("id:" + eachClass.get("cls_id") + "\tName:" + eachClass.get("cls_name") + "\n");
		}
	}

	public void update() {
		try {
			String sql = "update db_class set db_class.cls_name = '" + className + "' where db_class.cls_id = "
					+ idForUpdate;
			this.conn.query(sql);
			System.out.println("update success\n");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

//	public String inputNameOfClass() throws Exception {
//		try {
//			System.out.print("the name of the class >");
//			String className = in.nextLine();
//			return className;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
//
//	public int inputIdOfClass() throws Exception {
//		try {
//			System.out.print("the id of the class >");
//			int idClass = in.nextInt();
//			in.nextLine();
//			return idClass;
//		} catch (Exception e) {
//			e.printStackTrace();
//			in.nextLine();
//			return 0;
//		}
//	}

}
