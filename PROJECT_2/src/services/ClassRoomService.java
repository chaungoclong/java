package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.DBConnection;
import entities.ClassRoom;
import serviceInterface.ClassRoomManager;

public class ClassRoomService extends BaseService implements ClassRoomManager {
	private final String GET_ALL_CLASSROOM = "select * from class";
	private final String GET_CLASSROOM_BY_ID = "select * from class where class_id = ?";
	private final String ADD_CLASSROOM = "insert into class values(?, ?)";
	private final String UPDATE_CLASSROOM = "update class set class_name = ? where class_id = ?";
	private final String DELETE_CLASSROOM = "delete from class where class_id = ?";
	private final String CLASSROOM_IS_EXIST = "select * from class where class_id = ? or class_name = ?";
	private final String CHECK_FOR_UPDATE = "select * from class where class_name = ? and class_id != ?";
	private final String SEARCH_CLASSROOM = "select * from class where concat(class_id, ' ', class_name) like ?";

	public ClassRoomService(DBConnection dbc) {
		super(dbc);
	}

	// get all classroom
	@Override
	public List<ClassRoom> getAllClassRoom() throws Exception {
		List<ClassRoom> listClassRoom = new ArrayList<ClassRoom>();
		this.connect();

		PreparedStatement pstmt = this.conn.prepareStatement(GET_ALL_CLASSROOM);
		ResultSet rs = pstmt.executeQuery();
		listClassRoom = ClassRoom.listByResult(rs);

		rs.close();
		pstmt.close();
		this.disconnect();
		return listClassRoom;
	}

	// get classroom by id
	@Override
	public ClassRoom getClassRoomById(String id) throws Exception {
		ClassRoom classRoom = null;
		this.connect();

		PreparedStatement pstmt = this.conn.prepareStatement(GET_CLASSROOM_BY_ID);
		pstmt.setString(1, id.trim());
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			classRoom = new ClassRoom(rs.getString(1), rs.getString(2));
			break;
		}

		rs.close();
		pstmt.close();
		this.disconnect();

		return classRoom;
	}

	// add classroom
	@Override
	public boolean addClassRoom(ClassRoom classRoom) throws Exception {
		this.connect();

		PreparedStatement pstmt = this.conn.prepareStatement(ADD_CLASSROOM);
		pstmt.setString(1, classRoom.getClass_id().trim());
		pstmt.setString(2, classRoom.getClass_name().trim());

		int rowChange = pstmt.executeUpdate();
		pstmt.close();
		this.disconnect();

		return rowChange > 0;
	}

	// update classroom
	@Override
	public boolean updateClassRoom(ClassRoom classRoom) throws Exception {
		this.connect();

		PreparedStatement pstmt = this.conn.prepareStatement(UPDATE_CLASSROOM);
		pstmt.setString(1, classRoom.getClass_name().trim());
		pstmt.setString(2, classRoom.getClass_id().trim());

		int rowChange = pstmt.executeUpdate();
		pstmt.close();
		this.disconnect();

		return rowChange > 0;
	}

	// delete classroom
	@Override
	public boolean deleteClassRoom(String id) throws Exception {
		this.connect();

		PreparedStatement pstmt = this.conn.prepareStatement(DELETE_CLASSROOM);
		pstmt.setString(1, id.trim());

		int rowChange = pstmt.executeUpdate();
		pstmt.close();
		this.disconnect();

		return rowChange > 0;
	}

	// check classroom is exist
	@Override
	public boolean classRoomIsExist(ClassRoom classRoom) throws Exception {
		this.connect();

		PreparedStatement pstmt = this.conn.prepareStatement(CLASSROOM_IS_EXIST);
		pstmt.setString(1, classRoom.getClass_id().trim());
		pstmt.setString(2, classRoom.getClass_name().trim());
		ResultSet rs = pstmt.executeQuery();

		boolean check = rs.next() ? true : false;

		rs.close();
		pstmt.close();
		this.disconnect();

		return check;
	}

	// check classroom's name is exist -> update : return true if good for update
	// else return false
	@Override
	public boolean checkForUpdate(ClassRoom classRoom) throws Exception {
		this.connect();

		PreparedStatement pstmt = this.conn.prepareStatement(CHECK_FOR_UPDATE);
		pstmt.setString(1, classRoom.getClass_name().trim());
		pstmt.setString(2, classRoom.getClass_id().trim());
		ResultSet rs = pstmt.executeQuery();

//		System.out.println(rs.getMetaData());

		boolean check = rs.next() ? false : true;
		rs.close();
		pstmt.close();
		this.disconnect();

		return check;
	}
	
	// search 
	public List<ClassRoom> search(String key) throws Exception {
		List<ClassRoom> result = new ArrayList<ClassRoom>();
		this.connect();
		
		PreparedStatement pstmt = this.conn.prepareStatement(SEARCH_CLASSROOM);
		pstmt.setString(1, key);
		ResultSet rs = pstmt.executeQuery();
		result = ClassRoom.listByResult(rs);
		
		rs.close();
		pstmt.close();
		this.disconnect();
		
		return result;
	}

	// test
	public static void main(String[] args) {
		DBConnection db = DBConnection.getInstance();
		ClassRoomService a = new ClassRoomService(db);

//		// add classroom
//		ClassRoom newClassRoom = new ClassRoom("BKD04K11", "LAP TRINH 4");
//		try {
//			if (a.addClassRoom(newClassRoom)) {
//				System.out.println("add success");
//			}
//
//		} catch (Exception e) {
//			System.out.println("add fail");
//		}
//		
//		// update classroom by class_id
//		ClassRoom ClassRoomUpdate = new ClassRoom("BKD03K11", "LAP TRINH 333");
//		try {
//			if (a.updateClassRoom(ClassRoomUpdate)) {
//				System.out.println("update success");
//			}
//		} catch (Exception e) {
//			System.out.println("update fail");
//		}

		// detete classroom
//		try {
//			if(a.deleteClassRoom("hello")) {
//				System.out.println("delete success");
//			}
//		} catch (Exception e) {
//			System.out.println("delete fail");
//		}
//		
//		// get classroom by id
//		try {
//			ClassRoom classRoom = a.getClassRoomById("BKD03K11");
//			System.out.println(classRoom.getClass_id() + ":" + classRoom.getClass_name());
//		} catch (Exception e) {
//			System.out.println("get classroom by id fail");
//		}
//		
//		// get all classroom
		List<ClassRoom> list = new ArrayList<ClassRoom>();
		try {
			list = a.getAllClassRoom();
			System.out.println(list);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// check classRoom is exist
//		try {
//			if (a.classRoomIsExist(new ClassRoom("BdKD02K11", "lap trinh 2"))) {
//				System.out.println("classroom is already exist");
//			} else {
//				System.out.println("not found classroom");
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		// check for update
//		try {
//			System.out.println(a.checkForUpdate(new ClassRoom("BKD01K11", "Lập trình 2")));
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
		
		//search
		try {
			System.out.println(a.search("1"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
