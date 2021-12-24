package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

import com.app.core.Product;
import static utils.CollectionUtils.*;

public interface SerDeSerUtils {
	// add a static method to store collection(Map) of product details in bin file :
	// using Serialization(OOS)
	static void storeProductDetails(Map<Integer, Product> map, String fileName) throws IOException {
		// attach data strms
		// Java App ---> OOS : ser. --> bin stream(state + meta data) --> FOS (bin file)
		// : .ser
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
			out.writeObject(map);// ser.
		}
	}

	// add static method to restore products info (entire obj graph)
	@SuppressWarnings("unchecked")
	static Map<Integer, Product> restoreProducts(String fileName) throws IOException, ClassNotFoundException {
		// 1. validate file
		File f1 = new File(fileName);
		if (f1.exists() && f1.isFile() && f1.canRead()) {
			// attach suitable data strms : for de-serial
			try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(f1))) {
				// de-serial
				return (Map<Integer, Product>)in.readObject();
			}
		}
		//=> app launched for the 1st time => no data file
		return populateMapFromList(populateData());
	}

}
