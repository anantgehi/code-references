package tester;

import java.util.Scanner;
import static utils.DeSerIoUtils.restoreProducts;

public class TestDeSerialization {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter File Name ");
			System.out.println(restoreProducts(sc.nextLine()));//Expected o/p : {k1=v1......}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
