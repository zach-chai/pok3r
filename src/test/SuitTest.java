package test;

import static org.junit.Assert.*;
import main.Suit;

import org.junit.Test;

public class SuitTest {

	@Test
	public void testName() throws Exception {
		
		assertEquals("Diamonds", Suit.DIAMONDS.toString());
		assertEquals("Clubs", Suit.CLUBS.toString());
		assertEquals("Hearts", Suit.HEARTS.toString());
		assertEquals("Spades", Suit.SPADES.toString());
	}

}
