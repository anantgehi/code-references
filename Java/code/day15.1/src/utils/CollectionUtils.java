package utils;

import java.time.LocalDate;
import java.util.HashMap;

import com.app.banking.AccountType;
import com.app.banking.BankAccount;

import custom_exception.BankingException;

import static com.app.banking.AccountType.*;
import static java.time.LocalDate.parse;

public class CollectionUtils {
//add static method for populating map with sample data
	public static HashMap<Integer, BankAccount> populateMap() {
		HashMap<Integer, BankAccount> map = new HashMap<>();
		// int acctNo, AccountType acType, double balance, LocalDate creationDate,
		// String customerName
		System.out.println(map.put(101, new BankAccount(101, LOAN, 12345, parse("2020-01-01"), "Rama")));
		System.out.println(map.put(10, new BankAccount(10, CURRENT, 7345, parse("2019-12-21"), "Shekhar")));
		System.out.println(map.put(56, new BankAccount(56, FD, 500000, parse("2018-11-01"), "Riya")));
		System.out.println(map.put(78, new BankAccount(78, LOAN, 62345, parse("2021-05-01"), "Mihir")));
		System.out.println(map.put(34, new BankAccount(34, LOAN, 52345, parse("2021-11-11"), "Tara")));
		return map;
	}

	// add static method to accept a/c no n return a/c ref in case of success o.w
	// throw exc.
	public static BankAccount findByAccountNo(int acctNo, HashMap<Integer, BankAccount> map) throws BankingException {
		BankAccount a = map.get(acctNo);
		if (a == null)
			throw new BankingException("Invalid acct no !!!!");
		return a;
	}
}
