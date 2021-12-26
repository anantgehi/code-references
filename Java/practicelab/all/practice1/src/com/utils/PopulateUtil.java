package com.utils;

import java.util.ArrayList;

import com.student.Student;

public interface PopulateUtil {
	static ArrayList<Student> populateStudentDate() {
		ArrayList<Student> al = new ArrayList<Student>() ;
		al.add(new Student(1, "Tushar", "a@gmail.com", "63263", "MATHS", 94));
		al.add(new Student(2, "Ankit", "b@gmail.com", "63263", "SCIENCE", 94));
		al.add(new Student(3, "Aman", "c@gmail.com", "63263", "ENGLISH", 94));
		return al;
	}
}
