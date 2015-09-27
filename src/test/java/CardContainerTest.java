

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CardContainerTest {
	
	private CardContainer cards;
	private CardContainer cards2;
	private CardContainer cards3;
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
		
		cards2 = new CardContainer(
				new Card[] {
					new Card(Value.TWO, Suit.SPADES),
					new Card(Value.QUEEN, Suit.HEARTS),
					new Card(Value.ACE, Suit.HEARTS),
					new Card(Value.EIGHT, Suit.DIAMONDS),
					new Card(Value.SEVEN, Suit.CLUBS)
				});
		cards3 = new CardContainer(
				new Card[] {
						new Card(Value.TWO, Suit.SPADES),
						new Card(Value.QUEEN, Suit.HEARTS),
						new Card(Value.NINE, Suit.HEARTS),
						new Card(Value.EIGHT, Suit.DIAMONDS),
						new Card(Value.SEVEN, Suit.CLUBS)
					}
				);
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
		assertTrue(cards2.containsValue(Value.ACE));
		assertTrue(cards2.containsValue(Value.SEVEN));
		assertFalse(cards2.containsValue(Value.KING));
	}
	
	@Test
	public void testGetHighCard() throws Exception {
		assertEquals(new Card(Value.QUEEN, Suit.HEARTS), cards3.getHighCard());
		assertEquals(new Card(Value.ACE, Suit.HEARTS), cards2.getHighCard());
	}

}
