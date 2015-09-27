

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RankGeneratorTest {
	
	Hand[] hands = new Hand[10];

	@Before
	public void setUp() throws Exception {
		hands[0] = new Hand(
				new Card[] {
						new Card(Value.TWO, Suit.SPADES),
						new Card(Value.QUEEN, Suit.HEARTS),
						new Card(Value.NINE, Suit.HEARTS),
						new Card(Value.EIGHT, Suit.DIAMONDS),
						new Card(Value.SEVEN, Suit.CLUBS)
					}
				);
		hands[1] = new Hand(
				new Card[] {
						new Card(Value.TWO, Suit.SPADES),
						new Card(Value.QUEEN, Suit.HEARTS),
						new Card(Value.NINE, Suit.HEARTS),
						new Card(Value.QUEEN, Suit.DIAMONDS),
						new Card(Value.QUEEN, Suit.CLUBS)
				}
				);
		hands[2] = new Hand(
				new Card[] {
						new Card(Value.TWO, Suit.SPADES),
						new Card(Value.QUEEN, Suit.HEARTS),
						new Card(Value.NINE, Suit.HEARTS),
						new Card(Value.EIGHT, Suit.DIAMONDS),
						new Card(Value.QUEEN, Suit.CLUBS)
				}
				);
		hands[3] = new Hand(
				new Card[] {
						new Card(Value.TWO, Suit.HEARTS),
						new Card(Value.QUEEN, Suit.HEARTS),
						new Card(Value.NINE, Suit.HEARTS),
						new Card(Value.EIGHT, Suit.HEARTS),
						new Card(Value.SEVEN, Suit.HEARTS)
					}
				);
		hands[4] = new Hand(
				new Card[] {
						new Card(Value.TEN, Suit.CLUBS),
						new Card(Value.SEVEN, Suit.HEARTS),
						new Card(Value.NINE, Suit.HEARTS),
						new Card(Value.EIGHT, Suit.HEARTS),
						new Card(Value.JACK, Suit.HEARTS)
					}
				);
		hands[5] = new Hand(
				new Card[] {
						new Card(Value.TWO, Suit.SPADES),
						new Card(Value.QUEEN, Suit.HEARTS),
						new Card(Value.TWO, Suit.HEARTS),
						new Card(Value.QUEEN, Suit.DIAMONDS),
						new Card(Value.QUEEN, Suit.CLUBS)
				}
				);
		hands[6] = new Hand(
				new Card[] {
						new Card(Value.TWO, Suit.SPADES),
						new Card(Value.QUEEN, Suit.HEARTS),
						new Card(Value.TWO, Suit.HEARTS),
						new Card(Value.JACK, Suit.DIAMONDS),
						new Card(Value.QUEEN, Suit.CLUBS)
				}
				);
		hands[7] = new Hand(
				new Card[] {
						new Card(Value.QUEEN, Suit.SPADES),
						new Card(Value.QUEEN, Suit.HEARTS),
						new Card(Value.TWO, Suit.HEARTS),
						new Card(Value.QUEEN, Suit.DIAMONDS),
						new Card(Value.QUEEN, Suit.CLUBS)
				}
				);
		hands[8] = new Hand(
				new Card[] {
						new Card(Value.TEN, Suit.HEARTS),
						new Card(Value.SEVEN, Suit.HEARTS),
						new Card(Value.NINE, Suit.HEARTS),
						new Card(Value.EIGHT, Suit.HEARTS),
						new Card(Value.JACK, Suit.HEARTS)
					}
				);
		hands[9] = new Hand(
				new Card[] {
						new Card(Value.ACE, Suit.DIAMONDS),
						new Card(Value.QUEEN, Suit.DIAMONDS),
						new Card(Value.KING, Suit.DIAMONDS),
						new Card(Value.TEN, Suit.DIAMONDS),
						new Card(Value.JACK, Suit.DIAMONDS)
					}
				);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	public Integer[] getKindsForTesting(RankGenerator gen) {
		return gen.getKinds().toArray(new Integer[gen.getKinds().size()]);
	}
	
	@Test
	public void testGetKinds() throws Exception {
		RankGenerator gen = new RankGenerator(hands[0]);
		Integer[] expected = new Integer[]{1, 1, 1, 1, 1};
		assertArrayEquals(expected, getKindsForTesting(gen));
		
		gen = new RankGenerator(hands[1]);
		expected = new Integer[]{1, 3, 1};
		assertArrayEquals(expected, getKindsForTesting(gen));
		
		gen = new RankGenerator(hands[2]);
		expected = new Integer[]{1, 2, 1, 1};
		assertArrayEquals(expected, getKindsForTesting(gen));
		
		gen = new RankGenerator(hands[5]);
		assertArrayEquals(new Integer[]{2, 3}, getKindsForTesting(gen));
		
		gen = new RankGenerator(hands[6]);
		assertArrayEquals(new Integer[]{2, 2, 1}, getKindsForTesting(gen));
	}
	
	@Test
	public void testhasKind() throws Exception {
		RankGenerator gen = new RankGenerator(hands[0]);
		assertTrue(gen.hasKind(1));
		assertFalse(gen.hasKind(2));
		
		gen = new RankGenerator(hands[1]);
		assertFalse(gen.hasKind(2));
		assertTrue(gen.hasKind(3));
		
		gen = new RankGenerator(hands[5]);
		assertTrue(gen.hasKind(2));
		assertTrue(gen.hasKind(3));
		assertFalse(gen.hasKind(4));
		assertFalse(gen.hasKind(1));
	}

	@Test
	public void testIsOfMinimumKind() throws Exception {
		RankGenerator gen = new RankGenerator(hands[0]);
		assertTrue(gen.isOfMinimumKind(1));
		assertFalse(gen.isOfMinimumKind(2));
		assertFalse(gen.isOfMinimumKind(0));
		
		gen = new RankGenerator(hands[1]);
		assertTrue(gen.isOfMinimumKind(3));
		assertFalse(gen.isOfMinimumKind(4));
	}
	
	@Test
	public void testhasDuplicates() throws Exception {
		RankGenerator gen = new RankGenerator(hands[0]);
		assertFalse(gen.hasDuplicates());
		
		gen = new RankGenerator(hands[1]);
		assertTrue(gen.hasDuplicates());
		
		gen = new RankGenerator(hands[3]);
		assertFalse(gen.hasDuplicates());
		
		gen = new RankGenerator(hands[5]);
		assertTrue(gen.hasDuplicates());
	}
	
	@Test
	public void testHasFlush() throws Exception {
		RankGenerator gen = new RankGenerator(hands[0]);
		assertFalse(gen.hasFlush());
		
		gen = new RankGenerator(hands[3]);
		assertTrue(gen.hasFlush());
		
		gen = new RankGenerator(hands[4]);
		assertFalse(gen.hasFlush());
	}
	
	@Test
	public void testHasStraight() throws Exception {
		RankGenerator gen = new RankGenerator(hands[0]);
		assertFalse(gen.hasStraight());
		
		gen = new RankGenerator(hands[1]);
		assertFalse(gen.hasStraight());
		
		gen = new RankGenerator(hands[3]);
		assertFalse(gen.hasStraight());
		
		gen = new RankGenerator(hands[4]);
		assertTrue(gen.hasStraight());
	}
	
	@Test
	public void testHasOnePair() throws Exception {
		RankGenerator gen = new RankGenerator(hands[0]);
		assertFalse(gen.hasOnePair());
		
		gen = new RankGenerator(hands[2]);
		assertTrue(gen.hasOnePair());
		
		gen = new RankGenerator(hands[5]);
		assertTrue(gen.hasOnePair());
	}
	
	@Test
	public void testHasTwoPair() throws Exception {
		RankGenerator gen = new RankGenerator(hands[0]);
		assertFalse(gen.hasTwoPair());
		
		gen = new RankGenerator(hands[2]);
		assertFalse(gen.hasTwoPair());
		
		gen = new RankGenerator(hands[6]);
		assertTrue(gen.hasTwoPair());
	}
	
	@Test
	public void testHasThreeOfAKind() throws Exception {
		RankGenerator gen = new RankGenerator(hands[0]);
		assertFalse(gen.hasThreeOfAKInd());
		
		gen = new RankGenerator(hands[1]);
		assertTrue(gen.hasThreeOfAKInd());
		
		gen = new RankGenerator(hands[5]);
		assertTrue(gen.hasThreeOfAKInd());
		
		gen = new RankGenerator(hands[7]);
		assertFalse(gen.hasThreeOfAKInd());
	}
	
	@Test
	public void testHasFourOfAKind() throws Exception {
		RankGenerator gen = new RankGenerator(hands[0]);
		assertFalse(gen.hasFourOfAKind());
		
		gen = new RankGenerator(hands[5]);
		assertFalse(gen.hasFourOfAKind());
		
		gen = new RankGenerator(hands[7]);
		assertTrue(gen.hasFourOfAKind());
	}
	
	@Test
	public void testIsFullHouse() throws Exception {
		RankGenerator gen = new RankGenerator(hands[0]);
		assertFalse(gen.isFullHouse());
		
		gen = new RankGenerator(hands[5]);
		assertTrue(gen.isFullHouse());
		
		gen = new RankGenerator(hands[7]);
		assertFalse(gen.isFullHouse());
	}
	
	@Test
	public void testHasStraightFlush() throws Exception {
		RankGenerator gen = new RankGenerator(hands[0]);
		assertFalse(gen.hasStraightFlush());
		
		gen = new RankGenerator(hands[3]);
		assertFalse(gen.hasStraightFlush());
		
		gen = new RankGenerator(hands[4]);
		assertFalse(gen.hasStraightFlush());
		
		gen = new RankGenerator(hands[8]);
		assertTrue(gen.hasStraightFlush());
	}
	
	@Test
	public void testisRoyalFlush() throws Exception {
		RankGenerator gen = new RankGenerator(hands[0]);
		assertFalse(gen.isRoyalFlush());
		
		gen = new RankGenerator(hands[3]);
		assertFalse(gen.isRoyalFlush());
		
		gen = new RankGenerator(hands[4]);
		assertFalse(gen.isRoyalFlush());
		
		gen = new RankGenerator(hands[8]);
		assertFalse(gen.isRoyalFlush());
		
		gen = new RankGenerator(hands[9]);
		assertTrue(gen.isRoyalFlush());
	}
	
	@Test
	public void testHandCardRank() throws Exception {
		RankGenerator gen = new RankGenerator(hands[0]);
		assertEquals(HandCardRank.HighCard, gen.Generate());
		
		gen = new RankGenerator(hands[3]);
		assertEquals(HandCardRank.Flush, gen.Generate());
		
		gen = new RankGenerator(hands[4]);
		assertEquals(HandCardRank.Straight, gen.Generate());
		
		gen = new RankGenerator(hands[5]);
		assertEquals(HandCardRank.FullHouse, gen.Generate());
		
		gen = new RankGenerator(hands[8]);
		assertEquals(HandCardRank.StraightFlush, gen.Generate());
		
		gen = new RankGenerator(hands[9]);
		assertEquals(HandCardRank.RoyalFlush, gen.Generate());
	}

}
