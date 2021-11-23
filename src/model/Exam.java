package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the exam database table.
 * 
 */
@Entity
@Table(name = "exam")
@NamedQuery(name = "Exam.findAll", query = "SELECT e FROM Exam e")
public class Exam implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	public Exam() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Exam [id=" + id + ", name=" + name + "]";
	}

}