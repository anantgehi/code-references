package utils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import com.app.core.Customer;
import com.app.core.CustomerType;

import custom_exceptions.CustomerHandlingException;
import static com.app.core.Customer.sdf;

/*
 * Rules 
email must contain "@" & should be from ".com" domain
password must be min 4 max 10 chars long
dob should be before 1st Jan 1995
duplicate customer details should not be stored.
 */
public class ValidationRules {
	private static Date endDate;
	static {
		try {
			endDate = sdf.parse("1-1-1995");
		} catch (ParseException e) {
			System.out.println("err in static init block " + e);
		}
	}

//add static method for email validation
	public static void validateEmail(String email, ArrayList<Customer> customers) throws CustomerHandlingException {
		if (email.contains("@") && email.endsWith(".com")) {
			// => valid email format
			// chk for dup
			// create customer class instance to wrap PK : email
			Customer c1 = new Customer(email);
			// contains : equals since PK based searching
			if (customers.contains(c1))
				throw new CustomerHandlingException("Dup Email ID!!!!!");
		}
		throw new CustomerHandlingException("Invalid Email Format!!!!!");
	}

	// add static method for pwd validation
	public static void validatePassword(String password) throws CustomerHandlingException {
		if (password.length() < 4 || password.length() > 10)
			throw new CustomerHandlingException("Invalid password length!!!!");
	}

	// add static method for date validation
	public static Date parseAndValidateDoB(String dob) throws ParseException, CustomerHandlingException {
		// parsing
		Date d1 = sdf.parse(dob);
		// =>parsing succeeded! ....to validation
		if (!d1.before(endDate))
			throw new CustomerHandlingException("Invalid DoB!!!!");
		// => success
		return d1;
	}

	// add static method to parse n validation of customer type
	public static CustomerType parseAndValidateType(String custType, double regAmount)
			throws CustomerHandlingException {
		CustomerType plan = CustomerType.valueOf(custType.toUpperCase());
		if (plan.getPlanCost() != regAmount)
			throw new CustomerHandlingException("Invalid reg amount for the chosen plan");
		return plan;
	}

	// add static method to validate customer's all i/ps
	public static Customer validateAllInputs(String name, String email, String password, double regAmount, String dob,
			String type, ArrayList<Customer> customers) throws ParseException, CustomerHandlingException {
		validateEmail(email, customers);
		validatePassword(password);
		Date validatedDate = parseAndValidateDoB(dob);
		CustomerType cTYpe = parseAndValidateType(type, regAmount);
		return new Customer(name, email, password, regAmount, validatedDate, cTYpe);
	}

}
