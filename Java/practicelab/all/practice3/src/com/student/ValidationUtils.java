package com.student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

public interface ValidationUtils 
{
	static LocalDate checkRegDate(String date) throws Exception
	{
		LocalDate d1 = LocalDate.parse(date,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		LocalDate d2 = LocalDate.now();
		if(d1.isAfter(d2)) 
			return d1;
		throw new Exception("RegistrationDate should be after Current Date");
	}
	
	static Student inputDetails(String name,int age,String course,String regDate) throws Exception
	{
		LocalDate d1 = checkRegDate(regDate);
		return new Student(name, age, new ArrayList<String>(Arrays.asList(course)), d1);
	}
}
