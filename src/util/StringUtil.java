package util;

public class StringUtil {
	// format chuỗi về kiểu Camel
	public static String toCamel(String string, boolean type) {
		if (string == null) {
			return null;
		}

		String[] stringArray = string.split("[\\_\s]+");

		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < stringArray.length; i++) {
			String word = stringArray[i];

			if (i == 0 && type == false) {
				word = word.isEmpty() ? word : word.toLowerCase();
			} else {
				word = word.isEmpty() ? word : Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase();
			}

			builder.append(word);
		}

		return builder.toString();
	}
}
