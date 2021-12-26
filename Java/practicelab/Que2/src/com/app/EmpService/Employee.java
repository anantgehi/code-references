package com.app.EmpService;

import java.time.LocalDate;

public class Employee {
	
	private int id;
	private String name;
	private LocalDate dob;
	private LocalDate hireDate;
	private double salary;
	private Department department;
	
	
	public Employee(int id, String name,LocalDate dob, LocalDate hireDate, double salary, Department department) {
		super();
		this.id = id;
		this.name = name;
		this.dob=dob;
		this.hireDate = hireDate;
		this.salary = salary;
		this.department = department;
	}
	
	public Employee(int id) {
		super();
		this.id = id;
	}
	

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dob=" + dob + ", hireDate=" + hireDate + ", salary="
				+ salary + ", department=" + department + "]";
	}

	@Override
	public boolean equals(Object o)
	{
		System.out.println("......in Employee equals() method......");
		if(o instanceof Employee) return this.id==((Employee)o).id;
		return false;
	}
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public LocalDate getHireDate() {
		return hireDate;
	}


	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	public Department getDepartment() {
		return department;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}	

}
