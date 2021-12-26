package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import com.volunteer.Volunteer;

public interface SeSerIOUtil {
	@SuppressWarnings("unchecked")
	static ArrayList<Volunteer> deserializeDate(String file) throws IOException, ClassNotFoundException{
		File f = new File(file);
		if(f.exists() && f.isFile() && f.canRead()) 
			try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))){
				ArrayList<Volunteer> al = (ArrayList<Volunteer>) ois.readObject();
				return al;
			}
		return DataUtils.populateList();
	}
}
