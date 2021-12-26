package com.student;

public class Student {
	private Integer id;
	private String name,courseName,phoneNumber,email;
	private int marks;
	
	public Student(Integer id, String name, String email, String phoneNumber, String courseName, int marks) {
		this.id=id;
		this.name=name;
		this.email=email;
		this.phoneNumber=phoneNumber;
		this.courseName=courseName;
		this.marks=marks;
	}
	public Student(int id) {
		this.id=id;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", courseName=" + courseName + ", phoneNumber=" + phoneNumber
				+ ", email=" + email + ", marks=" + marks + "]";
	}
	

	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(obj instanceof Student)
			return (this.id == ((Student)obj).id);
		return false;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public void setMarks(int marks) {
		this.marks = marks;
	}


	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCourseName() {
		return courseName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public int getMarks() {
		return marks;
	}
	
	
}
