package service.impl;

import dao.impl.DoctorDAO;
import model.Doctor;
import service.IDoctorService;

public class DoctorService extends BaseService<Doctor> implements IDoctorService{
	public DoctorService () {
		this.dao = new DoctorDAO();
	}
}
