package util;

import javax.servlet.http.HttpServletRequest;

public class SessionUtil {
	// put
	public static void put(HttpServletRequest request, String key, Object value) {
		request.getSession().setAttribute(key, value);
	}
	
	// get
	public static Object get(HttpServletRequest request, String key) {
		return request.getSession().getAttribute(key);
	}
	
	// remove
	public static void remove(HttpServletRequest request, String key) {
		request.getSession().removeAttribute(key);
	}
}
