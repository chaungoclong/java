package dao.impl;

import dao.IExamDAO;
import model.Exam;

public class ExamDAO extends BaseDAO<Exam> implements IExamDAO{
	public ExamDAO () {
		this.init(Exam.class, "exam");
	}
}
