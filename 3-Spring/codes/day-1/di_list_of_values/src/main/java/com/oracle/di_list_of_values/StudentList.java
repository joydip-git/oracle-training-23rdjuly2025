package com.oracle.di_list_of_values;

//import java.util.ArrayList;
import java.util.List;

public class StudentList {
	private List<Student> students;

	public StudentList() {

	}

	public StudentList(List<Student> students) {
		this.students = students;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
}
