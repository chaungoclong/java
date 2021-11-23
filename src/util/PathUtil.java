package util;

import config.Const;

public class PathUtil {
	// asset path
	public static String asset(String path) {
		if (path == null) {
			throw new IllegalArgumentException();
		}

		return Const.ASSETS_PATH + path;
	}

	// asset path
	public static String view(String path) {
		if (path == null) {
			throw new IllegalArgumentException();
		}

		return Const.VIEW_PATH + path;
	}

	// asset path
	public static String url(String path) {
		if (path == null) {
			throw new IllegalArgumentException();
		}

		return Const.WEB_PATH + path;
	}

	public static void main(String[] args) {
		System.out.println(PathUtil.url("hello"));
	}
}
