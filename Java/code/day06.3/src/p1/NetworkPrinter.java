package p1;

public class NetworkPrinter implements Printer{
	//can imple class access i/f constants ? YES 
	//how ? using i/f name.memberName OR directly ? : DIRECTLY
	@Override
	public void print(String mesg)
	{
		System.out.println("Sending a mesg on the socket to the server : "+mesg);
		System.out.println(DATA);
	}

}
