package test_static;

import java.util.Scanner;
//to tell javac : accessing DIRECTLY static member : out from System class
import static java.lang.System.out;
//to tell javac : accessing DIRECTLY ALL  static members : from java.lang.Math class
import static java.lang.Math.*;
import static java.lang.System.in;

public class Test2 {
	static double pi2 = PI;

	public static void main(String[] args) {
		// can you access static members DIRECTLY : w/o using clsName.memberName : YES
		out.println("testing static keyowrd");
		out.println("Printing sqrt of 10 " + sqrt(10));
		out.println("PI " + PI);
		Scanner sc = new Scanner(in);
		double pi = PI;
		sc.close();

	}

}
