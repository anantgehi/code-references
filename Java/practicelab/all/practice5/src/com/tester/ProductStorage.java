package com.tester;

import java.util.ArrayList;
import java.util.Scanner;
import static com.app.utils.PopulateUtil.*;
import static com.app.utils.ValidationRules.*;
import static com.app.utils.SerIOUtil.*;
import com.app.product.Product;

public class ProductStorage 
{
	public static void main(String[] args) 
	{
		try(Scanner sc = new Scanner(System.in))
		{
			ArrayList<Product> list = populateList();
			boolean flag = true;
			while(flag) 
			{
				try 
				{
					System.out.println("1. Display Product List"
											+ "\n2. Add New Product"
											+ "\n3. Remove Product by Name"
											+ "\n4. Exit\n");
					System.out.print("Enter Choice: ");
					switch(sc.nextInt()) 
					{
					 	case 1: list.forEach(System.out::println);break;
					 	
					 	case 2: 
					 		System.out.println("Enter Product Name, Price and Expiry Date:");
					 		Product p = validateInputs(sc.next(), sc.nextDouble(), sc.next(), list);
					 		System.out.println("Product Added:"+list.add(p));
					 	break;
					 	
					 	case 3:
					 		System.out.print("Enter Product Name: ");
					 		String name = sc.next().toUpperCase();
					 		list.removeIf(l->l.getProductName().equals(name));
					 	break;
					 	
					 	default:
					 		System.out.print("Enter FilePath to save your data: ");
					 		serializeDate(sc.next(), list);
					 		System.out.println("\nTHANK YOU!!");
					 		flag=false;
						 break;
					}
				}
				catch(Exception e) 
				{
					System.out.println(e);
					sc.nextLine();
				}
			}
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
	}
}
