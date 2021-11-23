package util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCUtil {
	// chuyển resultSet thành List HashMap
	public static List<Map<String, Object>> resultSetToListHashMap(ResultSet resultSet) {
		List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();

		try {
			ResultSetMetaData metaData = resultSet.getMetaData();
			int numberColumns = metaData.getColumnCount();

			while (resultSet.next()) {
				Map<String, Object> row = new HashMap<String, Object>(numberColumns);

				for (int i = 1; i <= numberColumns; i++) {
					row.put(metaData.getColumnName(i), resultSet.getObject(i));
				}

				rows.add(row);
			}

			resultSet.close();
		} catch (Exception e) {
			return null;
		}

		return rows;
	}
}
