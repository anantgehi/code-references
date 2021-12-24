package test_inheritance;

import java.util.Scanner;

import inheritance.Faculty;
import inheritance.Person;
import inheritance.Student;

public class EventOrganiser {

	public static void main(String[] args) {
		// sc : stding
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter even capacity");
		// create suitable D.S to hold different type of participant details
		Person[] participants = new Person[sc.nextInt()];// 1 array holder obj : that can hold Person type refs.
		// which can later refer to either Student or Faculty type of the object :
		// thanks to upcasting!
		boolean exit = false;
		int counter = 0;
		while (!exit) {
			System.out.println(
					"Options 1. Register Student 2. Faculty Registration 3.Display info 4. Invoke specific functionality 100.Exit");
			System.out.println("Choose");
			switch (sc.nextInt()) {
			case 1: // student reg
				if (counter < participants.length) {
					System.out.println("Enter student details :  fn,  ln,  yr,  courseName,  marks,  fees");
					participants[counter++] = new Student(sc.next(), sc.next(), sc.nextInt(), sc.next(), sc.nextInt(),
							sc.nextInt());// up casting
				} else
					System.out.println("Event Full!!!!");

				break;
			case 2:// faculty reg
				if (counter < participants.length) {
					System.out.println("Enter faculty details :  fn,  ln,  exp in yrs   sme");
					participants[counter++] = new Faculty(sc.next(), sc.next(), sc.nextInt(), sc.next());// up casting
				} else
					System.out.println("Event Full!!!!");

				break;
			case 3: // display info : for-each
				for (Person p : participants)// p=participants[0],p=participants[1]......p=participants[participants.length-1]
					if (p != null)
						System.out.println(p);// {s1,s2,f1,s3,s4,null,null......} => run time poly.
				break;
			case 4:
				System.out.println("Enter Seat No");
				int index = sc.nextInt() - 1;
				if (index >= 0 && index < counter) {
					Person p1 = participants[index];
					if (p1 instanceof Student)
						((Student) p1).study();
					else if (p1 instanceof Faculty)
						((Faculty) p1).teach();

				} else
					System.out.println("Invalid seat no !!!!!!");
				break;

			case 100:
				exit = true;
				break;
			}
		}
		sc.close();

	}

}
