package p1;
/*
 * 0. Create different type of Printers(ConsolePrinter, FilePrinter ,NetworkPrinter)
 *  n access it's common functionality n specific functionality in a single for-each loop.
 */

public class Tester3 {

	public static void main(String[] args) {
		// array of i/f type of refs
		Printer[] printers = { new FilePrinter(), new ConsolePrinter(), new NetworkPrinter() };// 1 : array , 3 objs
		for (Printer p : printers) // p=printers[0],p=printers[1],p=printers[2]
		{
			p.print("test mesg!");// run time poly(DMD)
			if (p instanceof FilePrinter)
				((FilePrinter) p).closeFileHandle();
			else
				System.out.println("not a file printer....");
		}
	}

}
