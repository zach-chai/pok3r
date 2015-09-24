package main;

import java.util.ArrayList;
import java.util.List;

public class Round {
	
	List<Player> players;
	
	public Round(int numPlayers) {
		this.players = new ArrayList<Player>();
		for(int i = 0; i < numPlayers; i++) {
			players.add(new Player());
		}
	}
	
	public void inputPlayerHands() {
		
	}
	
	public void outputRanks() {
		
	}
	
	

}
