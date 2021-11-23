package util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import config.Const;

public class ServletUtil {
	// render view
	public static void view(String viewPath, HttpServletRequest request, HttpServletResponse response,
			boolean isForward) throws ServletException, IOException {
		viewPath = Const.VIEW_PATH + viewPath;
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);

		if (isForward) {
			dispatcher.forward(request, response);

			return;
		}

		dispatcher.include(request, response);

		return;
	}

	public static void view(String viewPath, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		view(viewPath, request, response, true);
	}

	// redirect
	public static void redirect(String url, HttpServletResponse response) throws IOException {
		response.sendRedirect(url);

		return;
	}

	// chuyển request về bean
	public static <T> T requestToBean(Class<T> clazz, HttpServletRequest request) {
		// map param từ request
		Map<String, String[]> mapParam = request.getParameterMap();

		// map chuyển thành bean
		Map<String, Object> mapData = new HashMap<String, Object>(mapParam.size());

		for (String key : mapParam.keySet()) {
			mapData.put(key, mapParam.get(key)[0]);
		}

		T object = MapperUtil.map(clazz, mapData);

		return object;
	}
}
