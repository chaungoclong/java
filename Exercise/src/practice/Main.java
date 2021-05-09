package practice;

public class Main {
	public static void main(String[] args) {
		try {
			Class<?> cls = Class.forName("practice.Programmer");
			Programmer a = (Programmer) cls.getDeclaredConstructor().newInstance();
			System.out.println(a.toString());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
