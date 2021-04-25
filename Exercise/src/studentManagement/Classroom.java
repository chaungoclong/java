package studentManagement;

//import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class Classroom {
	private int classId;
	private String condition;
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

	public void setCondition(String condition) {
		this.condition = condition;
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

	public ArrayList<HashMap<String, String>> showAll() {
		System.out.println("___LIST OF CLASS___\n");
		String sql = "select * from db_class";
		ArrayList<HashMap<String, String>> rs = this.conn.query(sql).getResult();
		return rs;
	}

	public void update() {
		try {
			String sql = "update db_class set db_class.cls_name = '" + className + "' where db_class.cls_id = "
					+ this.condition;
			this.conn.query(sql);
			System.out.println("update success\n");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void delete() {
		try {
			String sql = "delete from db_class where cls_id = " + this.condition;
			this.conn.query(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<HashMap<String, String>> search() {
		try {
			String sql = "select * from db_class where concat_ws(cls_id, cls_name) like('%" + this.condition + "%')";
			ArrayList<HashMap<String, String>> rs = this.conn.query(sql).getResult();

			return rs;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<HashMap<String, String>> sort(String orderByColumn, String mode) {
		try {
			String sql = "select * from db_class order by " + orderByColumn + " " + mode;
			ArrayList<HashMap<String, String>> rs = this.conn.query(sql).getResult();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
