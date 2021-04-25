package studentManagement;

import java.util.Scanner;

public class CommonController {
	private Scanner in = new Scanner(System.in);
	private View view = new View();
	private Classroom classRoom;

	public CommonController() {
		this.classRoom = new Classroom();
	}

// ++++++++++++++++++++CLASS++++++++++++++++++++++ 
	// add classroom
	public void addClassRoom() {
		try {
			// data for insert
			System.out.print("Name of Classroom >");
			String className = in.nextLine();
			this.classRoom.setClassName(className);
			
			// insert
			this.classRoom.add();
			
			// show result
			this.view.viewClassRoom(this.classRoom.showAll());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	// update classroom
	public void updateClassRoom() {
		try {
			// list of classroom
			this.view.viewClassRoom(this.classRoom.showAll());

			// condition
			System.out.print("The ID of the class you want to update >");
			String condition = in.nextLine();
			this.classRoom.setCondition(condition);;

			// data for update
			System.out.print("Name of Classroom >");
			String className = in.nextLine();
			this.classRoom.setClassName(className);

			// update
			this.classRoom.update();

			// show result
			System.out.println("After update");
			this.view.viewClassRoom(this.classRoom.showAll());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// delete classroom
	public void deleteClassRoom() {
		try {
			// list of classRoom
			this.view.viewClassRoom(this.classRoom.showAll());

			// condition
			System.out.println("The ID of the class you want to delete >");
			String condition = in.nextLine();
			this.classRoom.setCondition(condition);

			// delete
			this.classRoom.delete();

			// show result
			System.out.println("After delete");
			this.view.viewClassRoom(this.classRoom.showAll());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	// show list of classroom
	public void showListOfClassRoom() {
		try {
			this.view.viewClassRoom(this.classRoom.showAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// search classroom
	public void searchClassRoom() {
		try {
			System.out.print("Key word >");
			String keyWord = in.nextLine();
			this.classRoom.setCondition(keyWord);
			this.view.viewClassRoom(this.classRoom.search());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// sort classroom
	public void sortClassRoom(String orderByColumn, String mode) {
		try {
			this.view.viewClassRoom(this.classRoom.sort(orderByColumn, mode));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] abc) {
		// CommonController ctrl = new CommonController();

	}
}
