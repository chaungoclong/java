package serviceInterface;

import java.util.List;

import entities.ClassRoom;

public interface ClassRoomManager {
	// get all classroom
	List<ClassRoom> getAllClassRoom() throws Exception;
	
	// get class by class_id
	ClassRoom getClassRoomById(String id) throws Exception;
	
	// add one classroom
	boolean addClassRoom(ClassRoom classRoom) throws Exception;
	
	// update classroom
	boolean updateClassRoom(ClassRoom classRoom) throws Exception;
	
	// delete classroom
	boolean deleteClassRoom(String id) throws Exception;
	
	// check classroom is already exist
	boolean classRoomIsExist(ClassRoom classRoom) throws Exception;
	
	// check classroom's name is exist ->update
	boolean checkForUpdate(ClassRoom classRoom) throws Exception;
	
	List<ClassRoom> search(String key) throws Exception;
}
