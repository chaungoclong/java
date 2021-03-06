package learn;
import java.util.*;
import java.io.*;

public class Manager {
	private ArrayList<Student> ListStudents;
	private Scanner Scan = new Scanner(System.in);
	
	public Manager() {
		this.ListStudents = new ArrayList<Student>();
	}
	
	//add student
	public void AddStudent() {
		System.out.println("====Add New Student====\n");
		Student tmp = this.InputStudent();
		
		try {
			this.ListStudents.add(tmp);
			System.out.println("> (add student success)");
			
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//display student
	public void DisplayListStudent() {
		for (Student student : ListStudents) {
			student.ShowInfo();
		}
	}
	
	//edit student
	public void EditStudent() {
		System.out.print("ID for edit >");
		int ID = Scan.nextInt();
		Scan.nextLine();
		
		for (int i = 0; i < ListStudents.size(); ++i) {
			if(ListStudents.get(i).GetID() == ID) {
				EditStudentCore(i);
			}
		}
	}
	
	public void EditStudentCore(int ID) {
		try {
			Student tmp = InputStudent();
			ListStudents.set(ID, tmp);
			System.out.println("> edit success");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	// delete student
	public void DeleteStudent() {
		System.out.print("name or id for delete >");
		String Input = Scan.nextLine();
		String KeyWord = null;
		int ID = -1;
		
		if (IsNumeric(Input)) {
			try {
				ID = Integer.parseInt(Input);
			} catch (Exception e) {
				System.out.println("The input has been converted to string");
				KeyWord = FormatString(Input);
			}
		} else {
			KeyWord = FormatString(Input);
		}
		
		// if Student'S Name Like ID or Student'S ID Like ID insert its index to Indexs
		for (int i = 0; i < ListStudents.size(); i++) {
			if (ListStudents.get(i).GetID() == ID || ListStudents.get(i).GetName().trim().toLowerCase().equals(KeyWord)) {
				ListStudents.remove(i);
				System.out.println(ListStudents.size());
				System.out.println(i);
				i--;
			}
		}
		
		DisplayListStudent();
	}
	
	//return index of Student
	public int[] ReturnIndexOfStudent(String Input) {
		
		ArrayList<Integer> Indexs = new ArrayList<Integer>();
		String KeyWord = null;
		int ID = -1;
		
		// if input is numeric -> try convert it to Integer and set ID = input
		// if error convert it to String
		// if input is not numeric convert it to String
		if (IsNumeric(Input)) {
			try {
				ID = Integer.parseInt(Input);
			} catch (Exception e) {
				System.out.println("The input has been converted to string");
				KeyWord = FormatString(Input);
			}
		} else {
			KeyWord = FormatString(Input);
		}
		
		// if Student'S Name Like ID or Student'S ID Like ID insert its index to Indexs
		for (int i = 0; i < ListStudents.size(); i++) {
			if (ListStudents.get(i).GetID() == ID || ListStudents.get(i).GetName().trim().toLowerCase().equals(KeyWord)) {
				Indexs.add(i);
			}
		}
		
		// create new Array to save data of Indexs
		int[] ArrayIndexs = new int[Indexs.size()];
		
		
		// convert ArrayList To Array
		if (ArrayIndexs.length > 0) {
			for (int i = 0; i < Indexs.size(); i++) {
				ArrayIndexs[i] = Indexs.get(i);
			}
		}
		
		return ArrayIndexs;
	}
	
	
	// format String
	public String FormatString(String Str) {
		return Str.trim().toLowerCase();
	}
	
	// check String is numeric
	public boolean IsNumeric(String str) {
		if(str == null) {
			return false;
		}
		
		try {
			double tmp = Double.parseDouble(str);
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}
	
	
	
	public Student InputStudent() {
		System.out.println("Name >");
		String Name = Scan.nextLine();
		
		System.out.println("Age >");
		int Age = Scan.nextInt();
		Scan.nextLine();
		
		System.out.println("ClassName >");
		String ClassName = Scan.nextLine();
		
		Student tmp = new Student(Name, Age, ClassName);
		return tmp;
	}
	
	//search student by id
	public void SearchByID() {
		System.out.println("ID >");
		int ID = Scan.nextInt();
		Scan.nextLine();
		
		SearchByIDCore(ID);
	}
	
	public void SearchByIDCore(int ID) {
		try {
			if(ID < 0) {
				throw new NegativeException("ID > 0");
			} else {
				boolean founded = false;
				
				for (Student student : ListStudents) {
					if(student.GetID() == ID) {
						student.ShowInfo();
						founded = true;
					}
				}
				
				if(!founded) {
					System.out.println("not found");
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//search student by name
		public void SearchByName() {
			System.out.println("Name >");
			String Name = Scan.next();
			System.out.println(Name);
			SearchByNameCore(Name);
		}
		
		public void SearchByNameCore(String Name) {
			Name = Name.toLowerCase();
			
			for (Student student : ListStudents) {
				if(student.GetName().toLowerCase().trim().equals(Name)) {
					student.ShowInfo();
				}
			}
		}
}
