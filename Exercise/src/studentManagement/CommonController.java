package studentManagement;

import java.util.Scanner;

public class CommonController {
	private Scanner in = new Scanner(System.in);
	private Classroom classRoom;

	public CommonController() {
		this.classRoom = new Classroom();
	}

	public void addClassRoom() {
		try {
			System.out.print("Name of Classroom >");
			String className = in.nextLine();
			this.classRoom.setClassName(className);
			this.classRoom.add();
			this.classRoom.show();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	public void updateClassRoom() {
		try {
			// list of classroom
			this.classRoom.show();
			
			// condition
			System.out.print("The ID of the class you want to update >");
			int idForUpdate = in.nextInt();
			this.classRoom.setIdForUpdate(idForUpdate);
			in.nextLine();
			
			// data for update
			System.out.print("Name of Classroom >");
			String className = in.nextLine();
			this.classRoom.setClassName(className);
			
			// update
			this.classRoom.update();
			
			// show result
			System.out.println("_____AFTER UPDATE_____");
			this.classRoom.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] abc) {
		//CommonController ctrl = new CommonController();
		
	}
}
