package com.app.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;

import com.app.exception.ProductException;
import com.app.product.Product;


public interface ValidationRules {
	static void checkForDuplicacy(String name, double price, ArrayList<Product> list) throws ProductException{
		Product p = new Product(name.toUpperCase(),price);
		if(list.contains(p))
			throw new ProductException("This product already exists in our list");
		System.out.println("No Duplicate Product found");
	}
	
	static LocalDate validateExpiryDate(String date) throws ProductException{
		LocalDate expiryDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		LocalDate currentDate = LocalDate.now();
		if(expiryDate.isBefore(currentDate))
			throw new ProductException("Expiry Date should be greater than Current Date");
		return expiryDate;
	}
	
//	static void removeProduct(String name, ArrayList<Product> list){
//		String newName = name.toUpperCase();
//		Product p = new Product(newName);
//		Iterator<Product> itr = list.iterator();
//		while(itr.hasNext()) {
//			Product p1 = itr.next();
//			if(p1.equals(p))
//				itr.remove();
//		}
//	}
	
	static Product validateInputs(String name, double price, String date, ArrayList<Product> list) throws ProductException{
		checkForDuplicacy(name, price, list);
		LocalDate expiryDate = validateExpiryDate(date);
		return new Product(name.toUpperCase(), price, expiryDate);
	}
}
