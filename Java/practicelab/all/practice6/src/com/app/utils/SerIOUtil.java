package com.app.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import com.app.players.Player;

public interface SerIOUtil {
	static void serializeData(String fileName, HashMap<String, Player> teamList) throws IOException{
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
			oos.writeObject(teamList);
			System.out.println("PlayerList successfully saved in your given file....");
		}
	}
}
