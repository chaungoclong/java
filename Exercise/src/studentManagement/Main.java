package studentManagement;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		CommonController ctrl = new CommonController();
		int choice = 0;
		int choice2;

		do {
			primaryMenu();
			choice = in.nextInt();
			in.nextLine();

			switch (choice) {
			case 0:
				System.out.println("Thank you !\n");
				break;

			// class
			case 1:
				do {
					System.out.println("_____CLASS_____");
					System.out.println("1.Add\n2.Update\n3.Delete\n0.Exit");
					System.out.print("Your choice >");

					choice2 = in.nextInt();
					in.nextLine();

					switch (choice2) {
					case 0:
						break;
					
					// add
					case 1:
						System.out.println("add");
						ctrl.addClassRoom();
						break;
					
					// update	
					case 2:
						System.out.println("update");
						ctrl.updateClassRoom();
						break;
						
					// delete
					case 3:
						System.out.println("delete");
						break;
					
					default:
						System.out.println("Not found option");
						break;
					}
				} while (choice2 > 0);
				break;

			default:
				System.out.println("Not found option\n");
				break;
			}

		} while (choice > 0);
		in.close();
	}

	public static void primaryMenu() {
		System.out.println("_____MENU_____\n");
		System.out.println("1.Class\n2.Student\n3.Mark\n0.Exit\n");
		System.out.print("Your choice >");
	}

}
