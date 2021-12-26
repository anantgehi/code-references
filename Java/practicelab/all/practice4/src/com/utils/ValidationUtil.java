package com.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import com.exception.VolunteerException;
import com.volunteer.Volunteer;

public interface ValidationUtil {
	
	static void checkForDuplicacy(String name, String date, ArrayList<Volunteer> volunteers) throws VolunteerException{
		LocalDate d1 = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		Volunteer v = new Volunteer(name,d1);
		for(Volunteer v1:volunteers) {
			if(v1.equals(v))
			throw new VolunteerException("Volunteer already exists");
		}
		System.out.println("No Duplicacy Found");
	}
	
	static LocalDate checkDateOfBirth(String dob) throws VolunteerException{
		LocalDate fixed = LocalDate.of(1990, 01, 01);
		LocalDate dateOfBirth = LocalDate.parse(dob, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		if(dateOfBirth.isBefore(fixed))
			throw new VolunteerException("Date of Birth of any Volunter should be after 01/01/1990");
		return dateOfBirth;
	}
	
	static void displayVolunteerAccToHobbies(String hobbies,ArrayList<Volunteer> volunteers) {
		volunteers.stream().
		filter(v->v.getHobbies().contains(hobbies.toUpperCase())).
		forEach(System.out::println);
//		for(Volunteer v: volunteers) {
//			if(v.getHobbies().contains(hobbies.toUpperCase()))
//				System.out.println(v);
//		}
	}
	 
	static Volunteer validateInputs(String name, String hobbies, String isAvailable, String date, ArrayList<Volunteer> volunteers) throws VolunteerException {
		boolean available;
		checkForDuplicacy(name, date, volunteers);
		LocalDate dob = checkDateOfBirth(date);
		if(isAvailable.equals("Y") || isAvailable.equals("y"))
			available = true;
		else
			available = false;
		String newHobbies = hobbies.toUpperCase();
		ArrayList<String> al = new ArrayList<>(Arrays.asList(newHobbies.split(",")));
		return new Volunteer(name,al,available,dob);
		
	}
}
