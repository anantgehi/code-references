package com.app.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.app.product.Product;

public interface SerIOUtil {
	static void serializeDate(String file,ArrayList<Product> list) throws IOException{
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){
			oos.writeObject(list);
			System.out.println("Object Saved Successfully");
		}
	}
}
