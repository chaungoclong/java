package studentManagement;

import java.util.ArrayList;
import java.util.HashMap;

public class View {
	public View() {

	}

	public void viewClassRoom(ArrayList<HashMap<String, String>> listOfClassRoom) {
		if (listOfClassRoom.size() == 0) {
			System.out.println("empty");
		} else {
			System.out.println("\nID\t|\tNAME");
			for (HashMap<String, String> hashMap : listOfClassRoom) {
				System.out.println(hashMap.get("cls_id") + "\t|\t" + hashMap.get("cls_name"));
			}
		}
	}

	public void viewClassRoom() {

	}
}
