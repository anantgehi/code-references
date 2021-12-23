package p1;

public class Tester2 {
	// private Printer p;// p : i/f type of the ref. : Heap
	// private static Printer p;
	public static void main(String[] args) {
		Printer p;// i/f ref type var , mem allocated in stack : how many bytes : as per JVM spec
		// System.out.println(p);
		// p=new Printer();
		// can i/f ref DIRECTLY(w/o type casting) refer to concrete imple. class
		// instance ? YES
		p = new FilePrinter();// IS - A : implements : up casting
		p.print("something....");// no javac err : since print() : declared in Printer i/f , JVM invokes print :
									// FilePrinter's obj
		
		
	//	p.closeFileHandle();
		((FilePrinter)p).closeFileHandle();
		p=new ConsolePrinter();//up casting
		p.print("something....");
		((FilePrinter)p).closeFileHandle();

	}

}
