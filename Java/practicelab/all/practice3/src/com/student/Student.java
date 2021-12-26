package com.student;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Student implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int studentId,studentAge;
	private String studentName;
	private List<String> courseList;
	private LocalDate registrationDate;
	private static int counter;
	public Student(String name,int age,List<String> courses, LocalDate regDate) 
	{
		this.studentId=++counter;
		this.studentName=name;
		this.courseList=courses;
		this.registrationDate=regDate;
		this.studentAge=age;
	}
	
	public Student(List<String> courses) 
	{
		this.courseList=courses;
	}
	
	@Override
	public String toString() 
	{
		return "Student [studentId=" + studentId + ", studentAge=" + studentAge + ", studentName=" + studentName
				+ ", courseList=" + courseList + ", registrationDate=" + registrationDate + ", counter=" + counter
				+ "]";
	}
	
	public int getStudentId() 
	{
		return studentId;
	}
	
	public int getStudentAge() 
	{
		return studentAge;
	}
	
	public String getStudentName() 
	{
		return studentName;
	}
	
	public List<String> getCourseList() 
	{
		return courseList;
	}
	
	public LocalDate getRegistrationDate() 
	{
		return registrationDate;
	}	
}
