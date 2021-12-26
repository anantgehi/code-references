package com.app.utils;

import java.util.HashMap;

import com.app.exception.PlayerException;
import com.app.players.Player;

public interface ValidationRules {
	static void checkForDuplicacy(String name,double points,HashMap<String, Player> teamList) throws PlayerException{
		Player p = new Player(name,points);
		if(teamList.containsValue(p)) {
			throw new PlayerException("Duplicacy Found");
		}
		System.out.println("No Duplicacy found");
	}
	static boolean validateRanking(int ranking) throws PlayerException{
		if(ranking>5 || ranking<1)
			throw new PlayerException("Ranking should be between 1 to 5.");
		return true;
	}
	static void checkTeamSize(HashMap<String, Player> teamList) throws PlayerException{
		if(teamList.size()>6)
			throw new PlayerException("A team should always have 5-7 players only");
	}
	static void removeById(String id,HashMap<String, Player> teamList) throws PlayerException {
		if(teamList.containsKey(id))
				System.out.println(teamList.remove(id)+": removed successfully");
		else
			throw new PlayerException("No Player Found");
	}
	
	static Player validateInput(String id,String name,int ranking,double points,HashMap<String, Player> hm) throws PlayerException{
		if(hm.containsKey(id))
			throw new PlayerException("ID already exists");
		checkTeamSize(hm);
		checkForDuplicacy(name, points, hm);
		validateRanking(ranking);
		return new Player(id, name, ranking, points);
	}
}
