package learn;
import basic.Execute;
import java.util.*;

public class Main extends Execute {

	public static void main(String[] args) {
		int key = 0;
		Scanner scan = new Scanner(System.in);
		Manager manager = new Manager();
		
		do {
			Menu();
			key = scan.nextInt();
			scan.nextLine();
			
			switch (key) {
			case 1:
				echo("add");
				manager.AddStudent();
				break;
			
			case 2:
				echo("edit");
				manager.EditStudent();
				break;
			
			case 3:
				echo("delete");
				break;
				
			case 4:
				manager.DisplayListStudent();
				break;
				
			case 5:
				manager.SearchByID();
				break;
				
			case 6:
				manager.SearchByName();
				break;
				
			case 7:
				manager.DeleteStudent();
				break;

			default:
				key = 0;
				break;
			}
		} while (key != 0);
	}
	
	public static void Menu() {
		echo("===========MENU==============" + 
			"\n1-Add Student\n"
			+ "2-Edit student\n"
			+ "3-Delete Student\n"
			+ "4-Display\n"
			+ "5-Search By ID\n"
			+ "6-Search By Name\n"
			+ "7-Return Indexs\n"
			+ "0-Exit\n"
		);
	}
}
