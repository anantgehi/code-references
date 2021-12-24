package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public interface DeSerIoUtils {
//add static method to restore products info (entire obj graph)
	static Object restoreProducts(String fileName) throws IOException,ClassNotFoundException
	{
		//1. validate file
		File f1=new File(fileName);
		if(f1.exists() && f1.isFile() && f1.canRead())
		{
			//attach suitable data strms : for de-serial
			try(ObjectInputStream in=new ObjectInputStream(new FileInputStream(f1)))
			{
				//de-serial
				return in.readObject();
			}
		}
		return null;
	}
}
