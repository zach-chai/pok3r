package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import main.Card;
import main.HandCardRank;
import main.HandRank;
import main.Suit;
import main.Value;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class HandRankTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCompareToRank() throws Exception {
		
		ArrayList<HandRank> ranks = new ArrayList<HandRank>();
		for(HandCardRank rank: HandCardRank.values()) {			
			ranks.add(new HandRank(rank, new Card()));
		}
		
		for(int i = 0; i < ranks.size() - 1; i++) {
			assertTrue(ranks.get(i).compareTo(ranks.get(i + 1)) < 1);
		}
	}
	
	@Test
	public void testCompareToHighCard() throws Exception {
		
		HandCardRank rank = HandCardRank.Straight;
		HandRank lowerHighCard = new HandRank(rank, new Card(Value.EIGHT, Suit.CLUBS));
		HandRank higherHighCard = new HandRank(rank, new Card(Value.JACK, Suit.CLUBS));
		
		assertTrue(lowerHighCard.compareTo(higherHighCard) < 0);
		
		higherHighCard = new HandRank(rank, new Card(Value.ACE, Suit.CLUBS));
		
		assertTrue(lowerHighCard.compareTo(higherHighCard) < 0);
	}

}
