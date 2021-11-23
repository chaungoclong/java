package dao.impl;

import dao.IDoctorDAO;
import model.Doctor;

public class DoctorDAO extends BaseDAO<Doctor> implements IDoctorDAO {
	public DoctorDAO () {
		this.init(Doctor.class, "doctors");
	}
}
