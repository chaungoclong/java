package service.impl;

import dao.impl.ExamDAO;
import model.Exam;
import service.IExamService;

public class ExamService extends BaseService<Exam> implements IExamService {
	public ExamService() {
		this.dao = new ExamDAO();
	}
}
