package p1;
//import static p1.Printer.DATA;

public class Tester1 {

	public static void main(String[] args) {
		// create instance of ConsolePrinter
		//direct ref.
		ConsolePrinter printer=new ConsolePrinter();
		printer.print("some mesg!!!!");
		//direct ref. (type of the ref n type of the obj : SAME)
		FilePrinter filePrinter=new FilePrinter();
		filePrinter.print("another mesg");
		System.out.println(Printer.DATA);
		
		

	}

}
