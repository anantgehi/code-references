package tester;

import java.util.Date;
import java.util.Scanner;

import com.app.core.Customer;
import com.app.core.CustomerType;

import custom_exceptions.CustomerHandlingException;
import static utils.ValidationRules.validateAllInputs;

public class Tester1 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter max no of customers , to be registered ");// 100
			Customer[] customers = new Customer[sc.nextInt()];
			boolean exit = false;
			int counter = 0;
			while (!exit) {
				System.out.println("Options 1. Customer Registration 2.Display 3.Exit ");
				try {
					switch (sc.nextInt()) {
					case 1:
						if (counter < customers.length) {
							System.out.println(
									"Enter customer details : name,  email,  password,  regAmount,  dob(day-mon-ur),  type ");
							Customer c1 = validateAllInputs(sc.next(), sc.next(), sc.next(), sc.nextDouble(), sc.next(),
									sc.next(), customers);
							// => successful validations
							customers[counter++] = c1;
							System.out.println("Customer reg done!!!!");
						} else
							throw new CustomerHandlingException("Customer reg full!!!!!");
						break;
					case 2:
						System.out.println("Registered customer details");
						for (Customer c : customers)
							if (c != null)
								System.out.println(c);
						break;

					case 3:
						exit = true;
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();// name of exc class , err mesg , location
				}
				//clr off pending tokens from the scanner
				sc.nextLine();
			}
		}

	}

}
