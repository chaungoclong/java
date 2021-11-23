package util;

import java.util.stream.Stream;

public class ArrayUtil {
	// nối nhiều mảng
	public static Object[] arrConcat(Object[]... values) {
		System.out.println(values);
		return Stream.of(values).flatMap(Stream::of).toArray(Object[]::new);
	}
}
