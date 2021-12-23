/*
Solve : Write java application to accept int(emp id) , double(salary) , emp's first name , is permanent :  boolean from Scanner & display the same using printf
*/
import java.util.Scanner;

class TestScanner
{
	 public static void main(String[] ss)
	 {
		 //create scanner's instance to attach scanner to stdin
		 Scanner sc=new Scanner(System.in);
		 System.out.println("Enter emp id first name salary status : is permanent ");
		 System.out.printf("Emp ID %d Name %s Salary %.2f  Permanent Status %b %n",sc.nextInt(),sc.next(),sc.nextDouble(),sc.nextBoolean());
		 sc.close();
		 
	 }
}