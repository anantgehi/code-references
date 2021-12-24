package tester;

import java.util.ArrayList;
import java.util.Scanner;

import com.app.core.Customer;

import static utils.CollectionUtils.populateList;

public class CustomerManagementSystem {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// init phase of the app.
			// get populated AL from Utils
			ArrayList<Customer> list = populateList();
			boolean exit = false;
			while (!exit) {
				System.out.println("1. Register 2. Login 3. 100 Exit");
				try {
					switch (sc.nextInt()) {
					case 1://register

						break;
					case 2: //login
						break;
					case 3:
						break;
					case 4:// change password
						System.out.println("Enter email n password");
						authenticateCustomer(sc.next(),sc.next(),list);
						//chk if card is linked
						//change pwd : setter
						break;

					case 100:
						exit = true;
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				sc.nextLine();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
