package test_inheritance;

import inheritance.Faculty;
import inheritance.Person;
import inheritance.Student;

public class Test3 {

	public static void main(String[] args) {
		Person p = new Student("a2", "b2", 2020, "pg-dac", 80, 123456);// up casting
		System.out.println(p);// run time poly : JVM toString : Student
		// p.study();//study() deosn't exist in Person class
		((Student) p).study();// down casting
		p = new Faculty("a2", "b2", 10, "java c#sharp react");// up casting
		System.out.println(p);// o/p : run time poly : JVM toString : Faculty
	//	((Student) p).study();// no javac err , illegal casting : run time err : java.lang.ClassCastExc. :
								// Faculty can't be cat into Student
		//add instanceof checking , before explicit down casting 
		if(p instanceof Student)
			((Student) p).study();
		else
			System.out.println("invalid type!!!!!!!!!!!!!!!!!!!!!!!!");

	}

}
