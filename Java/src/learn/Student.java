package learn;

public class Student {
	
// Attribute
	private static int ID = 0;
	
	private int id;
	
	private String Name;
	
	private int Age;
	
	private String ClassName;
	

//	Method
	public Student() {
		this.id = ++ID;
		this.Name = "";
		this.Age = 0;
		this.ClassName = "";
		System.out.println(this.ID);
	}
	
	public Student(String Name, int Age, String ClassName) {
		this.id = ++ID;
		this.Name = Name;
		this.Age = Age;
		this.ClassName = ClassName;
		System.out.println(this.ID);
	}
	
//	getter
	public String GetName() {
		return this.Name;
	}
	
	public int GetAge() {
		return this.Age;
	}
	
	public String GetClassName() {
		return this.ClassName;
	}
	
	public int GetID() {
		return this.id;
	}
// setter
	
	public void SetName(String Name) {
		this.Name = Name;
	}
	
	public void SetAge(int Age) {
		this.Age = Age;
	}
	
	public void SetClassName(String ClassName) {
		this.ClassName = ClassName;
	}
	
	public void SetID(int ID) {
		this.id = ID;
	}
	
	public void ShowInfo() {
		System.out.println("ID:" + this.id + "\nName:" + this.Name + "\nAge:" + this.Age + "\nClassName:" + this.ClassName + "\n" );
	}
}
