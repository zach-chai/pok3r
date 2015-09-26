package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;

import main.Card;
import main.Suit;
import main.Value;

import org.junit.Test;

public class CardTest {
	
	Card card1;
	Card card2;
	Card card3;
	Card card4;
	
	@Before
	public void setUp() throws Exception {		
		card1 = new Card(Value.ACE, Suit.SPADES);
		card2 = new Card(Value.TWO, Suit.HEARTS);
		card3 = new Card(Value.KING, Suit.DIAMONDS);
		card4 = new Card(Value.FOUR, Suit.CLUBS);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testCard() throws Exception {
		
		Value value = Value.FIVE;
		Suit suit = Suit.HEARTS;
		
		Card card = new Card(value, suit);
		
		assertNotNull(card);
		assertEquals(value, card.getValue());
		assertEquals(suit, card.getSuit());
	}
	
	@Test
	public void testToString() throws Exception {
		assertEquals("AceSpades", card1.toString());
		assertEquals("TwoHearts", card2.toString());
	}
	
	@Test
	public void testConstructingFromString() throws Exception {
		assertEquals(card4, new Card("FourClubs"));
		assertEquals(card3, new Card("KingDiamonds"));
	}
	
}
