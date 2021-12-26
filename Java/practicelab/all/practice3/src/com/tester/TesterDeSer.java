package com.tester;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import com.student.Student;

public class TesterDeSer {

	public static void main(String[] args){
		System.out.println("Enter File name: ");
		try(Scanner sc = new Scanner(System.in);
				FileInputStream fis = new FileInputStream(sc.nextLine());
				ObjectInputStream ois = new ObjectInputStream(fis)){
		ArrayList<Student> students = new ArrayList<>();
		Student s = (Student)ois.readObject();
		while(s!=null) {
			try {
			students.add(s);
			s=(Student)ois.readObject();
			}catch(Exception e){
				break;
			}
		}	
		students.stream().forEach(System.out::println);
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
