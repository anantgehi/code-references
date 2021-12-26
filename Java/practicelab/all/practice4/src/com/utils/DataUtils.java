package com.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import com.volunteer.Volunteer;

public interface DataUtils {
	static ArrayList<Volunteer> populateList(){
		ArrayList<Volunteer> al = new ArrayList<Volunteer>();
		al.add(new Volunteer("Tushar", new ArrayList<String>(Arrays.asList("WATCHINGCRICKET","BIKERIDING","CHILDWELFARE")), true, LocalDate.parse("1998-04-25")));
		al.add(new Volunteer("Siddharth", new ArrayList<String>(Arrays.asList("CHATTING","PHEKU","BIKERIDING")), true, LocalDate.parse("2002-10-14")));
		al.add(new Volunteer("Ankit", new ArrayList<String>(Arrays.asList("BROWSINGINTERNET","BIKERIDING","CHILDWELFARE")), true, LocalDate.parse("1996-04-25")));
		al.add(new Volunteer("Aman", new ArrayList<String>(Arrays.asList("WATCHINGCRICKET","WATCHINGYOUTUBEVIDEOS","CHILDWELFARE")), true, LocalDate.parse("1997-04-25")));
		al.add(new Volunteer("Shubhankar", new ArrayList<String>(Arrays.asList("CLUBBING","BIKERIDING")), true, LocalDate.parse("1997-06-25")));
		al.add(new Volunteer("Shivam", new ArrayList<String>(Arrays.asList("WATCHINGCRICKET","BIKERIDING")), true, LocalDate.parse("1997-05-25")));
		al.add(new Volunteer("Harsh", new ArrayList<String>(Arrays.asList("WATCHINGCRICKET","BIKERIDING")), true, LocalDate.parse("1997-07-25")));
		al.add(new Volunteer("Aashu", new ArrayList<String>(Arrays.asList("WATCHINGCRICKET","BIKERIDING")), true, LocalDate.parse("1998-10-25")));
		al.add(new Volunteer("Yash", new ArrayList<String>(Arrays.asList("WATCHINGCRICKET","BIKERIDING")), true, LocalDate.parse("1998-02-25")));
		al.add(new Volunteer("Durvesh", new ArrayList<String>(Arrays.asList("WATCHINGCRICKET","BIKERIDING")), true, LocalDate.parse("1996-05-25")));
		return al;
	}
}
