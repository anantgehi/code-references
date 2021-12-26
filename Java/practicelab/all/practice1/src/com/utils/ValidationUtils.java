package com.utils;

import java.util.ArrayList;
import java.util.Iterator;

import com.exception.StudentException;
import com.student.Student;

public interface ValidationUtils {
	static void displayAllStudents(String courseName, ArrayList<Student> al) {
//		for(Student s : al) {
//			if(s.getCourseName().equals(courseName)) {
//				System.out.println(s);
//			}
//		}
		al.stream().filter(s->s.getCourseName().equals(courseName)).forEach(System.out::println);
	}
	
	static void updateStudentDetails(Integer id, int newMarks, String newPhoneNo, ArrayList<Student> al) throws StudentException{
		Student s = new Student(id);
		boolean flag = false;
		for(Student s1 : al) {
			if(s1.equals(s)) {
				flag=true;
				s1.setMarks(newMarks);
				s1.setPhoneNumber(newPhoneNo);
			}		
		}
		if(flag==false) {
			throw new StudentException("Student Not Found");
		}
	}
	static void cancelStudentAdmission(String email, ArrayList<Student> al) throws StudentException{
		Iterator<Student> itr = al.iterator();
		boolean flag = false;
		while(itr.hasNext()) {	
			if(itr.next().getEmail().equals(email)) {
				flag = true;
				itr.remove();
			}
		}
		if(flag == false) {
			throw new StudentException("Student Not Found");
		}
		 
	}
}
