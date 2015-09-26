package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.Card;
import main.Hand;

public class HandTest {

	Hand hand1;
	Hand hand2;
	Hand hand3;
	@Before
	public void setUp() throws Exception {
		Card[] cards = new Card[] {new Card(), new Card(), new Card(), new Card(), new Card()};
		hand1 = new Hand();
		hand2 = new Hand(cards);
		hand3 = new Hand(new String[]{"AceSpades", "TwoHearts", "FourClubs", "TenDiamonds", "QueenClubs"});
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConstruction() throws Exception {
		assertNotNull(hand1);
		assertNotNull(hand2);
		assertNotNull(hand3);
	}
	
	@Test
	public void testRankGeneration() throws Exception {
		hand2.generateRank();
		hand3.generateRank();
		assertNotNull(hand2.getRank());
		assertNotNull(hand3.getRank());
	}

}
