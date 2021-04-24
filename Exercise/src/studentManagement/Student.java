package studentManagement;

public class Student extends Person {
	private int classId;
	private Database conn = new Database("localhost", "3306", "long", "tnt", "student_java");

	public Student() {
		super();
	}

	public Student(String name, int age, int gender, String address, String phoneNumber, int classId) {
		super(name, age, gender, address, phoneNumber);
		this.classId = classId;
	}

	// add
	public void add() {

	}

	// delete
	public void delete() {

	}

	// update
	public void update() {

	}

}
