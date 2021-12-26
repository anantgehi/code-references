package com.app.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import com.app.players.Player;

public interface PopulateUtils {
	static ArrayList<Player> populateList(){
		ArrayList<Player> al = new ArrayList<>(Arrays.asList(new Player("P1", "Tushar", 1, 566),
				new Player("P2", "Siddharth", 2, 523),new Player("P3", "Aman", 3, 674),
				new Player("P4", "Ankit", 1, 870),new Player("P5", "Shubhankar", 2, 465)));
		return al;
	}
	
	static HashMap<String, Player> populateMap(ArrayList<Player> al){
		HashMap<String, Player> teamMap = new HashMap<>();
		for(Player p : al) {
			teamMap.put(p.getPlayerId(), p);
		}
		return teamMap;
	}
}
