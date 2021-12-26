package com.tester;

import java.util.ArrayList;
import java.util.Scanner;

import com.employee.Employee;
import com.utils.ValidationUtils;

public class EmpService {
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			ArrayList<Employee> employees = new ArrayList<>();
			boolean flag = true;
			while(flag) {
				try {
					System.out.println("Enter Choice: ");
					switch(sc.nextInt()) {
						case 1: System.out.println("Enter id, name, dob(dd/MM/yyy), hiredate(dd/MM/yyyy), salary, department");
								Employee e1 = ValidationUtils.inputValidation(sc.next(),sc.next(), sc.next(), sc.next(), sc.nextDouble(), sc.next(), employees);
								employees.add(e1);
								break;
						case 2: Employee e2 = ValidationUtils.getEmpDetails(sc.next(), employees);
								System.out.println(e2);
								break;
						case 3: employees.stream().sorted().forEach(System.out::println);
								break;
						case 4: ValidationUtils.removeEmployee(sc.next(), employees);
								break;
						default:
								System.out.println("THANK YOU!!");
								flag=false;
								break;
					}
				}catch(Exception e) {
					System.out.println(e);
					sc.nextLine();
				}
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
