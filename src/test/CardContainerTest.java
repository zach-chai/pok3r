package test;

import static org.junit.Assert.*;
import main.Card;
import main.CardContainer;
import main.Suit;
import main.Value;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CardContainerTest {
	
	private CardContainer cards;
	private Card[] cardArray;
	private Card cardRef;
	private int size;

	@Before
	public void setUp() throws Exception {
		
		int num = 4;
		cardRef = new Card();
		
		cardArray = new Card[num];
		for(int i = 0; i < num - 1; i++) {
			cardArray[i] = new Card();
		}
		cardArray[num - 1] = cardRef;
		
		cards = new CardContainer(cardArray);
		size = cards.getCards().size();
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testAdd() throws Exception {
		
		cards.add(new Card());
		assertEquals(size + 1, cards.getCards().size());
	}
	
	@Test
	public void testRemove() throws Exception {
		
		cards.remove(cardRef);
		assertEquals(size - 1, cards.getCards().size());
	}
	
	@Test
	public void testcontainsValue() throws Exception {
		CardContainer cards = new CardContainer(
				new Card[] {
					new Card(Value.TWO, Suit.SPADES),
					new Card(Value.QUEEN, Suit.HEARTS),
					new Card(Value.ACE, Suit.HEARTS),
					new Card(Value.EIGHT, Suit.DIAMONDS),
					new Card(Value.SEVEN, Suit.CLUBS)
				});
		assertTrue(cards.containsValue(Value.ACE));
		assertTrue(cards.containsValue(Value.SEVEN));
		assertFalse(cards.containsValue(Value.KING));
	}

}
