package p1;

public class Tester2 {
	// private Printer p;// p : i/f type of the ref. : Heap
	// private static Printer p;//mem allocated in method area : once at the cls
	// loading tine
	public static void main(String[] args) {
		Printer p;// i/f ref type var , mem allocated in stack : how many bytes : as per JVM spec
		// System.out.println(p);
		// p=new Printer();
		// can i/f ref DIRECTLY(w/o type casting) refer to concrete imple. class
		// instance ? YES
		p = new FilePrinter();// IS - A : implements : up casting
		p.print("something....");// no javac err : since print() : declared in Printer i/f , JVM invokes print :
									// FilePrinter's obj : run time poly(=dynamic method dispatch)

		// p.closeFileHandle();
		if (p instanceof FilePrinter)
			((FilePrinter) p).closeFileHandle();// prog : explicit downcast , no runtime err.method exec : succeeds!
		else
			System.out.println("Err 1 : not a FilePrinter....");
		p = new ConsolePrinter();// up casting
		p.print("something....");// DMD : dyn method dispatch
		if (p instanceof FilePrinter)
			((FilePrinter) p).closeFileHandle();// run time err : ClassCastExc : ConsolePrinter can'e be cast i to
												// Fileprinter
		else
			System.out.println("Err 2 : not a FilePrinter....");

	}

}
