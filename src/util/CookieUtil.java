package util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
	// get
	public static Cookie get(String name, HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(name)) {
					return cookie;
				}
			}
		}

		return null;
	}

	// put
	public static void put(HttpServletResponse response, String name, String value, int maxAge) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(maxAge);
		response.addCookie(cookie);
	}

	// remove
	public static void remove(String name, HttpServletResponse response, HttpServletRequest request) {
		Cookie cookie = get(name, request);

		if (cookie != null) {
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
	}
}
