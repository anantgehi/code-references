package com.tester;

import java.util.ArrayList;
import java.util.Scanner;

import com.student.Student;
import com.utils.PopulateUtil;
import com.utils.ValidationUtils;

public class StudentManagementSysytem {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			ArrayList<Student> students = PopulateUtil.populateStudentDate();
			boolean flag = true;
			while(flag) {
				System.out.println("\n1. Display Students in a particular course\n2. Update Student Details\n3. Cancel Admission\nEnter Choice:");
				try {
					switch(sc.nextInt()) {
						case 1: 
							System.out.println("Enter Course Name: ");
							ValidationUtils.displayAllStudents(sc.next().toUpperCase(), students);
							break;
						case 2:
							System.out.println("Enter StudentID, New Marks, New Phone: ");
							ValidationUtils.updateStudentDetails(sc.nextInt(),sc.nextInt(),sc.next(),students);
							break;
						case 3:
							System.out.println("Enter EmailID: ");
							ValidationUtils.cancelStudentAdmission(sc.next(), students);
							break;
						default:
							System.out.println("THANK YOU!!");
							flag=false;
							break;
					}
				}catch(Exception e) {
					System.out.println(e);
				}
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
