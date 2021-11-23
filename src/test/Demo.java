package test;

import model.Exam;
import service.impl.ExamService;

public class Demo {
	public static void main(String[] args) {
		ExamService s = new ExamService();
		
		Exam e = new Exam();
		e.setName("abc");
		
		System.out.println(s.create(e));
	}
}
