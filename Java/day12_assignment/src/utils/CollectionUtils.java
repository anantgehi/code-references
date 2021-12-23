package utils;

import java.text.ParseException;
import java.util.ArrayList;

import com.app.core.Customer;
import static com.app.core.Customer.sdf;
import static com.app.core.CustomerType.*;

public class CollectionUtils {
//add static method to return populate AL of customers
	public static ArrayList<Customer> populateList() throws ParseException {
		ArrayList<Customer> list = new ArrayList<>();
		list.add(new Customer("Rama", "rama@gmail.com", "12345", 500, sdf.parse("1-1-1990"), SILVER));
		list.add(new Customer("Mihir", "mihir@gmail.com", "42345", 1500, sdf.parse("11-5-1991"), DIAMOND));
		list.add(new Customer("Anish", "anish@gmail.com", "17345", 1000, sdf.parse("1-1-1989"), GOLD));
		list.add(new Customer("Riya", "riya@gmail.com", "88345", 1000, sdf.parse("11-10-1992"), GOLD));
		list.add(new Customer("Shubham", "shubham@gmail.com", "98345", 1000, sdf.parse("11-1-1993"), GOLD));
		return list;

	}
}
