package tester;

import static utils.SpeedUtils.validateSpeed;

import java.util.Scanner;

public class TestCustomException {

	public static void main(String[] args) /* throws SpeedOutOfRangeException */ {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter speed");
			validateSpeed(sc.nextInt());
			System.out.println("end of try...");
		} // sc.close()
		catch (Exception e) {
		//	System.out.println(e.getMessage());
	//		e.printStackTrace();
			System.out.println(e);
	
		}
		System.out.println("main cntd....");

	}

}
