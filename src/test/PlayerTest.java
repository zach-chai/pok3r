package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Player;

public class PlayerTest {

	@Test
	public void testId() throws Exception {
		
		Player[] players = new Player[4];
		for(int i = 0; i < players.length; i++) {			
			players[i] = new Player();
		}
		for(int i = 0; i < players.length; i++) {
			assertEquals(0, players[0].getId());
		}
		
	}

}
