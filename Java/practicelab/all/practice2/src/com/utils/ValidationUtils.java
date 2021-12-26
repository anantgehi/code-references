package com.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;

import com.department.Department;
import com.employee.Employee;
import com.exception.EmployeeException;

public class ValidationUtils {
	private static LocalDate BEFOREDATE;
	private static LocalDate AFTERDATE;
	
	static {
		AFTERDATE=LocalDate.parse("01/01/2018",DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		BEFOREDATE=LocalDate.parse("01/01/2022",DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	
	public static boolean checkForDuplicacy(String id,ArrayList<Employee> al) throws EmployeeException{
		Employee e = new Employee(id);
		if(al.contains(e)) {
			throw new EmployeeException("ID already exists..");
		}
		return true;
	} 
	
	public static Employee getEmpDetails(String id, ArrayList<Employee> al) throws EmployeeException {
		Employee e1 = new Employee(id);
		int index = al.indexOf(e1);
		if (index == -1)
			throw new EmployeeException("Not found");
		else
			return al.get(index);
	}
	
	public static LocalDate checkForHireDate(String date) throws EmployeeException{
		LocalDate d = LocalDate.parse(date,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		if(d.isBefore(BEFOREDATE) && d.isAfter(AFTERDATE)) 
			return d;
		else
			throw new EmployeeException("HireDate is invalid..");
	}
	
	public static Department checkDepartment(String dept){
		return Department.valueOf(dept.toUpperCase());
	}
	public static void removeEmployee(String id,ArrayList<Employee> al) {
		Iterator<Employee> itr = al.iterator();
		while(itr.hasNext()) {
			if(itr.next().getId().equals(id)) {
				itr.remove();
			}
		}
	}
	public static Employee inputValidation(String id,String name, String dob, String hiredate, Double salary, String dept, ArrayList<Employee> al) throws EmployeeException{
		checkForDuplicacy(id, al);
		LocalDate d1 = checkForHireDate(hiredate);
		Department deptName = checkDepartment(dept);
		return new Employee(id, name, LocalDate.parse(dob,DateTimeFormatter.ofPattern("dd/MM/yyyy")), d1, salary, deptName);
	}
}
