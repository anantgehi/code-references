package com.tester;

import static com.utils.DataUtils.populateList;

import java.util.ArrayList;
import java.util.Scanner;
import static com.utils.ValidationUtil.*;
import com.volunteer.Volunteer;
import static com.utils.SerIOUtil.*;
import static com.utils.SeSerIOUtil.*;
public class FunctionVolunteers 
{
	public static void main(String[] args) 
	{
		try(Scanner sc = new Scanner(System.in))
		{
			ArrayList<Volunteer> volunteers = populateList();
			boolean flag = true;
			while(flag) 
			{
				try 
				{
					System.out.println("1. Add Volunteer"
											+ "\n2. Display Volunteers"
											+ "\n3. Display Volunteers by their Hobbies"
											+ "\n4. Serialize Data"
											+ "\n5. Deserialize Data"
											+ "\n6. Exit\n");
					
					System.out.print("Enter choice: ");
					switch(sc.nextInt()) 
					{
						case 1: System.out.println("Enter Name, Hobbies(To write multiple hobbies use ',' and Please don't give space between them), IsAvailable(Y/N), Date of Birth(dd/MM/yyyy)");
								Volunteer v = validateInputs(sc.next(), sc.next(), sc.next(), sc.next(), volunteers);
								volunteers.add(v);
						break;
						
						case 2: volunteers.forEach(System.out::println);break;
						
						case 3: 
								System.out.println("Enter Hobby Name (Please don't give any space): ");
								String hobby = sc.next();
								displayVolunteerAccToHobbies(hobby,volunteers);
						break;
						
						case 4: System.out.print("Enter File Path: ");
								serializeDate(sc.next(), volunteers);
						break;
						
						case 5: System.out.print("Enter File Path: ");
								ArrayList<Volunteer> newList = deserializeDate(sc.next());
								newList.forEach(System.out::println);
						break;
						
						default: System.out.println("THANK YOU!!");
								 flag = false;
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
