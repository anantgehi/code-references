package com.app.utils;

import java.time.LocalDate;
import java.util.ArrayList;

import com.app.product.Product;

public interface PopulateUtil 
{
	static ArrayList<Product> populateList()
	{
		ArrayList<Product> list = new ArrayList<>();
		list.add(new Product("BIKE", 150000, LocalDate.parse("2022-04-25")));
		list.add(new Product("CAR", 750000, LocalDate.parse("2022-05-25")));
		list.add(new Product("HOUSE", 15000000, LocalDate.parse("2022-01-25")));
		list.add(new Product("LAPTOP", 150000, LocalDate.parse("2021-12-30")));
		list.add(new Product("MOBILE", 30000, LocalDate.parse("2022-01-01")));
		return list;
	}
}
