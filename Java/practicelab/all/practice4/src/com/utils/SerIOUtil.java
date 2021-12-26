package com.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.volunteer.Volunteer;

public interface SerIOUtil {
	static void serializeDate(String fileName,ArrayList<Volunteer> al) throws IOException{
		try(FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
			oos.writeObject(al);
		}
	}
}
