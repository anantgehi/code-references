package p1;

public class FilePrinter implements Printer {

	@Override
	public void print(String mesg) {
		System.out.println("Storing  a mesg in the file : "+mesg);
	}
	//can imple class add new func ?  YES
	public void closeFileHandle()
	{
		System.out.println("closing file handle...");
	}

}
