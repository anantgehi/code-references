package exc_handling;

import java.util.Scanner;

public class TestTryWithResources {

	public static void main(String[] args) throws InterruptedException{
		//create scanner instance : to be closed implicitly by JVM
		try(Scanner sc=new Scanner(System.in))
		{
			System.out.println("Enter your complete name");
			System.out.println("Hello , "+sc.nextLine());
			Thread.sleep(100);
		}//JVM invokes : sc.close()
		System.out.println("main over....");

	}

}
