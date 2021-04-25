package studentManagement;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		CommonController ctrl = new CommonController();
		int choice = 0;
		int choice2 = 0;
		int choice3 = 0;

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
					System.out.println("1.Add\n2.Update\n3.Delete\n4.List Of Classroom\n5.Search\n6.Sort\n0.Exit");
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
						ctrl.deleteClassRoom();
						break;
						
					// list of classroom
					case 4:
						System.out.println("list");
						ctrl.showListOfClassRoom();
						break;
						
					// search classroom
					case 5:
						System.out.println("search");
						ctrl.searchClassRoom();;
						break;
					
					// sort classroom
					case 6:
						System.out.println("sort");
						do {
							System.out.println("\n1.Sort by ID ASC\n2.Sort by ID DESC\n"
									+ "3.Sort by Name ASC\n4.Sort By Name DESC\n0.Exit\n");
							System.out.print("Your choice >");
							
							choice3 = in.nextInt();
							in.nextLine();
							
							switch (choice3) {
							case 0:
								break;
							
							// sort by id asc
							case 1:
								System.out.println("sort by id asc");
								ctrl.sortClassRoom("cls_id", "asc");
								break;
							
							// sort by id desc
							case 2:
								System.out.println("sort by id desc");
								ctrl.sortClassRoom("cls_id", "desc");
								break;
								
							// sort by name asc
							case 3:
								System.out.println("sort by name asc");
								ctrl.sortClassRoom("cls_name", "asc");
								break;
							
							// sort by name desc
							case 4:
								System.out.println("sort by name desc");
								ctrl.sortClassRoom("cls_name", "desc");
								break;

							default:
								System.out.println("Not found option");
								break;
							}
						} while (choice3 > 0);
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
