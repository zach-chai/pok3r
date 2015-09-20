package test;

import static org.junit.Assert.*;
import main.Deck;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DeckTest {

	Deck deck;
	
	@Before
	public void setUp() throws Exception {
		deck = new Deck();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testLoadDeck() throws Exception {
		assertEquals(52, deck.getCards().size());
	}

}
