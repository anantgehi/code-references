package test_inheritance;

import inheritance.Faculty;
import inheritance.Person;
import inheritance.Student;

public class Test2 {

	public static void main(String[] args) {
		// super cls ref , super cls instance , sub cls ref , sub cls obj (Person ,
		// Student , Faculty)
		Person p;// p : super cls ref
		p = new Person("a1", "b1");// lhs : super cls ref --> super cls instance , : DIRECT referencing
		p = new Student("a2", "b2", 2020, "pg-dac", 80, 123456);// LHS : super cls ref ---> sub class instance
		// why no javac err : extends : Student IS-A Person ---up casting : implicitly
		// done by javac
		Object o;// o : universal super cls ref
		o = p;// no javac err : Person IS-A Object
		// System.out.println(o);
		// Emp <----Mgr <----HRMgr
		// Emp e=new HRMgr(.....);//up casting
		System.out.println(p);// p.toString : javac chks by type of the ref : p : Person , what will be o/p :
		// student's toString : this decision of invoking toString method , on which
		// type of the instance is taken dynamically(ie. @run time) => run time polymorphism
		System.out.println(o);//JVM will invoke toString : on Student
		o=new Faculty("a2", "b2", 10, "java c#sharp react");//up casting
		System.out.println(o);//o/p : faculty 's complete dtls : method binding : run time => run time poly.

	}

}
