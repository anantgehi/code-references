package com.employee;
import java.time.LocalDate;
import com.department.Department;

public class Employee implements Comparable<Employee>{
	private String id,name;
	private LocalDate dob,hiredate;
	private Double salary;
	private Department dept;
	
	public Employee(String id,String name,LocalDate dob,LocalDate hiredate,Double salary,Department dept) {
		this.id=id;
		this.name=name;
		this.dob=dob;
		this.hiredate=hiredate;
		this.salary=salary;
		this.dept=dept;
	}
	public Employee(String id) {
		this.id=id;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(obj instanceof Employee)
			return this.id.equals(((Employee) obj).id);
		return false;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public LocalDate getHiredate() {
		return hiredate;
	}

	public Double getSalary() {
		return salary;
	}

	public Department getDept() {
		return dept;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dob=" + dob + ", hiredate=" + hiredate + ", salary="
				+ salary + ", dept=" + dept + "]";
	}
	@Override
	public int compareTo(Employee o) {
		if(this.hiredate.compareTo(o.hiredate)>0)
		return 1;
		if(this.hiredate.compareTo(o.hiredate)<0)
		return -1;
		return 0;
		
	}
	
}
