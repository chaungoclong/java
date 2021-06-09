package helpers;

public class NumberHelper {
	public static boolean isNumeric(String check) {
		if (check == null) {
			return false;
		}

		try {
			Double.parseDouble(check);
		} catch (Exception e) {
			return false;
		}

		return true;
	}
}
