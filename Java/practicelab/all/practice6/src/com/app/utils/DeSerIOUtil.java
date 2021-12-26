package com.app.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;

import com.app.players.Player;

public interface DeSerIOUtil {
	@SuppressWarnings("unchecked")
	static HashMap<String, Player> deserializeData(String fileName) throws ClassNotFoundException, IOException{
		File f = new File(fileName);
		if(f.exists()&&f.isFile()&&f.canRead()) { 
			try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))){
				HashMap<String,Player> teamList = (HashMap<String,Player>)ois.readObject();
				return teamList;
			}
		}
		return PopulateUtils.populateMap(PopulateUtils.populateList());
	}
}
