package tester;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.app.vehicles.Category;
import com.app.vehicles.Vehicle;
import static utils.VehicleValidationRules.*;

public class Showroom {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// create empty AL to hold Vehicle type of refs.
			ArrayList<Vehicle> vehicles = new ArrayList<>();// size =0 , capa =10
			boolean exit = false;
			while (!exit) {
				System.out.println("Options 1. Add Vehicle 2. Display 3. Find by chasis no 4.Update Price 10. Exit");
				try {
					switch (sc.nextInt()) {
					case 1: // add a vehicle
						System.out.println(
								"Enter vehicle details : chasisNo,  color,  price,  manufactureDate(day-mon-yr), category");
						vehicles.add(validateAllInputs(sc.nextInt(), sc.next(), sc.nextDouble(), sc.next(), sc.next(),
								vehicles));
						System.out.println("vehicle added to the showroom....");

						break;
					case 2: // display all vehicles
						System.out.println("Showroom details");
						for (Vehicle v : vehicles)
							System.out.println(v);

						break;
					case 3:
						System.out.println("Enter chasis no");
						System.out.println(findByChasisNo(sc.nextInt(), vehicles));
						break;
						
					case 4 : System.out.println("Enter chasis no n new price");
					   Vehicle v=findByChasisNo(sc.nextInt(), vehicles);
					   v.setPrice(sc.nextDouble());
					   System.out.println("Price updated for the vehicle with chasis no "+v.getChasisNo());
						break;
						
					case 5: System.out.println("Enter chasis no to remove vehile details from the showroom");
					v=findByChasisNo(sc.nextInt(), vehicles);
					//vehicle found
					System.out.println("removed "+vehicles.remove(v));					
					System.out.println("vehicle details removed...."+v);
					break;

					case 10:
						exit = true;
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				// to read off pending tokens from the scanner : till end of line
				sc.nextLine();

			}

		}

	}

}
