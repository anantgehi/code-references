package test_static;

//Can static methods access other static members(data/method) directly(w/o instance) -- YES
//Can static methods access other non-static members directly(w/o instance) -- NO
//Can non-static methods access other static members directly(w/o instance) -- YES
public class Test1 {
	private static int i;
	private int j;

	public static void main(String[] args) {
		System.out.println("printing " + i);
		show();
		// System.out.println(j);
		// how to acces j ? : with obj creation
		Test1 t1 = new Test1();
		System.out.println(t1.j);
//		print();
//		t1.show();

	}

	private static void show() {
		System.out.println("in show " + i/* +" "+j */);
		//print();
	}

	private void print() {
		System.out.println("in print " + i);// non static method CAN ACCESS DIRECTLY static + non static members
											// directly
		show();
	//	main(new String[] {"aa","bb"});
		
	}

}
