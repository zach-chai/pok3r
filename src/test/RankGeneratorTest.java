package test;

import static org.junit.Assert.*;

import java.time.temporal.IsoFields;

import main.Card;
import main.Hand;
import main.RankGenerator;
import main.Suit;
import main.Value;

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
		assertFalse(gen.hasDuplicates());
		assertFalse(gen.isStraight());
		
		gen = new RankGenerator(hands[1]);
		assertTrue(gen.isOfMinimumKind(3));
		assertFalse(gen.isOfMinimumKind(4));
		assertTrue(gen.hasDuplicates());
		assertFalse(gen.hasKind(2));
		assertFalse(gen.isStraight());
		
		gen = new RankGenerator(hands[3]);
		assertTrue(gen.isFlush());
		assertFalse(gen.isStraight());
		
		gen = new RankGenerator(hands[4]);
		assertFalse(gen.isFlush());
		assertTrue(gen.isStraight());
		
		gen = new RankGenerator(hands[5]);
		assertTrue(gen.hasKind(2));
		assertTrue(gen.hasKind(3));
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
	public void testIsStraight() throws Exception {
		RankGenerator gen = new RankGenerator(hands[0]);
		assertFalse(gen.isStraight());
		
		gen = new RankGenerator(hands[1]);
		assertFalse(gen.isStraight());
		
		gen = new RankGenerator(hands[3]);
		assertFalse(gen.isStraight());
		
		gen = new RankGenerator(hands[4]);
		assertTrue(gen.isStraight());
	}
	

}
