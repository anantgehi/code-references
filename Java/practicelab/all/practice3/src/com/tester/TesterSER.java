package com.tester;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.student.Student;
import com.student.ValidationUtils;

public class TesterSER 
{
	public static void main(String[] args) 
	{
		System.out.println("Enter File name: ");
		try(Scanner sc = new Scanner(System.in);
				
				FileOutputStream fos = new FileOutputStream(sc.nextLine());
				ObjectOutputStream oos = new ObjectOutputStream(fos))
		{
			ArrayList<Student> students = new ArrayList<>();
			boolean flag = true;
			while(flag) {
				try {
				System.out.print("Enter Choice: ");
				switch(sc.nextInt()) {
					case 1: System.out.println("Enter name, age, course, regDate");
							Student s = ValidationUtils.inputDetails(sc.next(), sc.nextInt(), sc.next(), sc.next());
							students.add(s);
							break;
					case 2:
						String a = sc.next();
						Student s3 = new Student(new ArrayList<String>(Arrays.asList(a)));
						for(Student s2 : students) {
							if(s2.getCourseList().equals(s3.getCourseList())) {
								System.out.println(s2);
							}
						}
					break;
					default:
							System.out.println("For Serialization");
							for(Student s1 : students) {
								oos.writeObject(s1);
								System.out.println("Done");
							}
							flag = false;
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
