package basic;
import java.util.HashMap;

public class Hash_Map extends Execute {

	public static void main(String[] args) {
		HashMap<String, String> abc = new HashMap<String, String>();
		abc.put("Name:", "Chau Ngoc Long");
		abc.put("Age:", "19");
		abc.remove("Name:");
		for(String i : abc.keySet()) {
			echo(abc.get(i));
			echo("\n");
		}
		echo(abc.size());
		
	}

}
