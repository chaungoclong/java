package inClass;
import java.util.*;
import java.sql.*;
import basic.Execute;

public class Manager extends Execute{
	private Scanner scan = new Scanner(System.in);
	private ArrayList<Student> ListStudents;
	
	public Manager() {
		this.ListStudents = new ArrayList<Student>();
	}
	
	// add student
	public void addStudent() {
		int key = 0;
		while (true) {
			echo ("===NEW STUDENT===\n");
			try {
				Student newStudent = inputStudent();
				ListStudents.add(newStudent);
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_java", "long", "tnt");
					
					String SQL = "insert into student(stu_name, stu_c, stu_php, stu_avg, stu_rank)"
							+ "values(" 
							+ "'" +newStudent.getName() + "'," 
							+ newStudent.getC() + "," 
							+ newStudent.getPHP() + ","
							+ newStudent.getMarkAVG() + ","
							+ "'" +newStudent.getRank()
							+ "')";
					echo (SQL);
					
					Statement stmt = con.createStatement();
					boolean status = stmt.execute(SQL);
					echo ("\nstatus: " + status + "\n");
					
					if (!status) {
						echo ("add to database success\n");
					} else {
						echo ("add to database fail\n");
					}
					
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				echo ("add success!\n1-Continue\t0-exit\n>");
				
				try {
					key = scan.nextInt();
					scan.nextLine();
				} catch (Exception e) {
					echo ("Please enter the integer\n");
					scan.nextLine();
					break;
				}
				
				if (key == 0) {
					break;
				}
				
			} catch (Exception e) {
//				echo(e.getMessage());
//				e.printStackTrace();
				break;
			}
		}
	}
	
	public Student inputStudent() {
		String ClassName = inputName();
		float C = inputC();
		float PHP = inputPHP();
		
		return new Student(ClassName, C, PHP);
	}
	
	public String inputName() {
		echo ("Name >");
		String name = scan.nextLine();
		return name;
	}
	
	public int inputID() {
		echo ("ID >");
		int ID = scan.nextInt();
		scan.nextLine();
		return ID;
	}
	
	public float inputC() {
		echo ("C >");
		float C = scan.nextFloat();
		scan.nextLine();
		return C;
	}
	
	public float inputPHP() {
		echo ("PHP >");
		float PHP = scan.nextFloat();
		scan.nextLine();
		return PHP;
	}
	
	// edit student
	public void editStudent() {
		if (ListStudents.size() > 0) {
			echo ("Name or ID for Edit>");
			String strForSearch = scan.nextLine();
			int[] listIndexsForEdit = returnIndexsOfStudent(strForSearch);
			boolean success = true;
			
			for (int i = 0; i < listIndexsForEdit.length; i++) {
				try {
					Student tmp = inputStudent();
					ListStudents.set(listIndexsForEdit[i], tmp);
				} catch (Exception e) {
					success = false;
					echo ("some error :((");
					break;
				}
			}
			
			if (success) {
				echo ("Edit success "+ listIndexsForEdit.length +" Student!!!\n");
			}
		} else {
			echo ("no data !!!\n");
		}
	}
	
	// delete student
	public void deleteStudent() {
		if (ListStudents.size() > 0) {
			echo ("Name or ID for Delete>");
			String strForSearch = scan.nextLine();
			int[] listIndexsForDelete = returnIndexsOfStudent(strForSearch);
			boolean success = true;
			
			for (int i = 0; i < listIndexsForDelete.length; i++) {
				try {
					ListStudents.remove(listIndexsForDelete[i]);
				} catch (Exception e) {
					success = false;
					echo ("some error :((");
					break;
				}
			}
			
			if (success) {
				echo ("Delete success "+ listIndexsForDelete.length +" Student!!!\n");
			}
		} else {
			echo ("No data !!!\n");
		}
	}
	
	// search student
	public void searchStudents() {
		echo ("ID or Name for search >");
		String strForSearch = scan.nextLine();
		int[] listIndexsForSearch = returnIndexsOfStudent(strForSearch);
		
		for (int i = 0; i < listIndexsForSearch.length; i++) {
			
		}
	}
	
	// return index of student
	public int[] returnIndexsOfStudent(String strForSearch) {
		int ID = 0;
		String name = "";
		ArrayList<Integer> arrayListIndexs = new ArrayList<Integer>();
		
		if (isNumeric(strForSearch)) {
			try {
				ID = Integer.parseInt(strForSearch);
			} catch (Exception e) {
				name = formatString(strForSearch);
			}
		} else {
			name = formatString(strForSearch);
		}
		
		for (int i = 0; i < ListStudents.size(); i++) {
			if(ListStudents.get(i).getID() == ID || ListStudents.get(i).getName().trim().toLowerCase().equals(name)) {
				arrayListIndexs.add(i);
			}
		}
		
		return arrayListIndexs.stream().mapToInt(val -> val).toArray();
	}
	
	// string is numeric
	public static boolean isNumeric(String str) {
		if (str == null) {
			return false;
		}
		
		try {
			Double.parseDouble(str);
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}
	
	// format String
	public String formatString(String str) {
		return str.trim().toLowerCase();
	}
	
	
	// show student
	public void showListStudent() {
		echo ("===LIST STUDENT (" + ListStudents.size() + " student)===\n");
		for (Student student : ListStudents) {
			student.showInfo();
		}
		echo ("===END LIST STUDENT===\n\n");
	}
}
