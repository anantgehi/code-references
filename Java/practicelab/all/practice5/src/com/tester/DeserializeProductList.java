package com.tester;

import java.util.ArrayList;
import java.util.Scanner;

import com.app.product.Product;

import static com.app.utils.DeSerIOUtil.*;

public class DeserializeProductList {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			ArrayList<Product> list = deserializeData(sc.next());
			list.forEach(System.out::println);
		}catch(Exception e) {
			System.out.println(e);
		}

	}

}
