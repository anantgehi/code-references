package tester;

import com.app.shapes.*;

public class TestAbstraction {

	public static void main(String[] args) {
		// create rectangle n circle instances , add their refs in the array n display
		// their details + area from single for-each
		BoundedShape[] shapes= {new Rectangle(10, 20, 20.5,4.6),new Circle(50, 100, 12.5)};//3 objecs
	//	BoundedShape s1=new BoundedShape(30,60);
		for(BoundedShape s : shapes)
		{
			System.out.println(s);
			System.out.printf("Area : %10.2f %n",s.area());
		}
		

	}

}
