package inClass;
import basic.Execute;
import java.util.*;

public class Main extends Execute{

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Manager manager = new Manager();
		AnimationConsole ac = new AnimationConsole();
		char key = 'x';
		/*
		 * if(Manager.isNumeric("123.0")) { echo ("ok"); } else { echo ("no"); }
		 */
		
		do {
			menu();
			key = in.next().charAt(0);
			
			switch (key) {
			case '1':
				manager.addStudent();
				break;
				
			case '2':
				manager.showListStudent();
				break;
			
			case '3':
				manager.editStudent();
				break;
			
			case '4':
				manager.deleteStudent();
				manager.showListStudent();
				break;

			case 'x':
			case 'X':
				ac.printTextSlow("===Thank you===", 100);
				in.close();
				break;
				
			default:
				echo ("no option!!!\n");
				break;
			}
		} while (key != 'x' && key != 'X');
		

	}
	
	public static void menu() {
		echo ("__________MENU__________"
				+ "\n1-ADD"
				+ "\n2-SHOW"
				+ "\n3-EDIT"
				+ "\n4-DELETE"
				+ "\nX-BACK\n"
		);
	}

}
