package com.app.players;

import java.io.Serializable;

public class Player implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6815340350671812646L;
	String playerName, playerId;
	int ranking;
	double points;
	public Player(String playerId,String playerName,int ranking, double points) {
		this.playerId = playerId;
		this.playerName=playerName;
		this.ranking=ranking;
		this.points=points;
	}
	public Player(String name, double points) {
		this.playerName=name;
		this.points=points;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj==null)
			return false;
		if(obj instanceof Player)
			return this.playerName.equals(((Player)obj).playerName) && ((Double)this.points==((Player)obj).points);
		return false;
	}
	@Override
	public String toString() {
		return "Player [playerName=" + playerName + ", playerId=" + playerId + ", ranking=" + ranking + ", points="
				+ points + "]";
	}
	public String getPlayerName() {
		return playerName;
	}
	public String getPlayerId() {
		return playerId;
	}
	public int getRanking() {
		return ranking;
	}
	public double getPoints() {
		return points;
	}
	
}
