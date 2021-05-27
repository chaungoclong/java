package entities;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClassRoom {
	private String class_id;
	private String class_name;

	public ClassRoom(String class_id, String class_name) {
		super();
		this.class_id = class_id;
		this.class_name = class_name;
	}

	public String getClass_id() {
		return class_id;
	}

	public void setClass_id(String class_id) {
		this.class_id = class_id;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	// create new Object by ResultSet
	public static List<ClassRoom> listByResult(ResultSet rs) throws Exception {
		List<ClassRoom> list = new ArrayList<ClassRoom>();
		while (rs.next()) {
			list.add(new ClassRoom(rs.getString(1), rs.getString(2)));
		}
		return list;
	}

	@Override
	public String toString() {
		return "ClassRoom [class_id=" + class_id + ", class_name=" + class_name + ", getClass_id()=" + getClass_id()
				+ ", getClass_name()=" + getClass_name() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
