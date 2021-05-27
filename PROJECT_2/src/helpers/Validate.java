package helpers;

public class Validate {
	public static boolean isEmptyString(String str) {
		return !(str != null && str.trim() != "");
	}
	
	public static void main(String[] args) {
		System.out.println(Validate.isEmptyString("hello"));
	}
}
