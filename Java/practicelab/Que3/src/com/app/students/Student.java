package com.app.students;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private static int id_count;
	
	private String name;
	private int id;
	private int age;
	private List<String> courseList;
	private List<LocalDate> regDateList;
	
	{   //instance block
		id_count=id_count+1;
	}

	public Student(String name,int age) {
		super();
		this.name = name;
		this.age = age;
		this.id = id_count;
		courseList= new ArrayList<String>();
		regDateList = new ArrayList<LocalDate>();
	}
	
	public Student(int id)
	{
		this.id=id;
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("......in Student equals() method......");
		if(obj instanceof Student) return this.id==((Student)obj).id;
		return false;
	}

	@Override
	public String toString() {
		
		String courses = courseList.size() == 0 ? "Not enrolled in any course yet!!" : Arrays.toString(courseList.toArray());
		return "Student [ Student Name=" + name + ", id=" + id + ", age=" + age + ", Courses Enrolled= " + courses +" ]";			 
	}

	public List<String> getCourseList() {
		return courseList;
	}

	public void addCourse(String course) {
		this.courseList.add(course);
	}

	public List<LocalDate> getRegDateList() {
		return regDateList;
	}

	public void addRegDate(LocalDate regDate) {
		this.regDateList.add(regDate);
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}
	

}
