package test;

import static org.junit.Assert.*;
import main.Card;
import main.Suit;
import main.Value;

import org.junit.Test;

public class CardTest {
	
	@Test
	public void testCard() throws Exception {
		
		Value value = Value.FIVE;
		Suit suit = Suit.HEARTS;
		
		Card card = new Card(value, suit);
		
		assertNotNull(card);
		assertEquals(card.getValue(), value);
		assertEquals(card.getSuit(), suit);
	}
	
	@Test
	public void testToString() throws Exception {
		
		Card card1 = new Card(Value.ACE, Suit.SPADES);
		Card card2 = new Card(Value.TWO, Suit.HEARTS);
		
		assertEquals("AceSpades", card1.toString());
		assertEquals("TwoHearts", card2.toString());
	}
	
}
