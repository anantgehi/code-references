package com.app.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import com.app.product.Product;

public interface DeSerIOUtil {
	@SuppressWarnings("unchecked")
	static ArrayList<Product> deserializeData(String file) throws IOException, ClassNotFoundException{
		File f = new File(file);
		if(f.exists()&&f.canRead()&&f.isFile()) {
			try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))){
				return (ArrayList<Product>) ois.readObject();
			}
		}
		return PopulateUtil.populateList();
	}
}
