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
		
	}

	@After
	public void tearDown() throws Exception {
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
		assertFalse(gen.isStraight());
		
		gen = new RankGenerator(hands[3]);
		assertTrue(gen.isFlush());
		assertFalse(gen.isStraight());
		
		gen = new RankGenerator(hands[4]);
		assertFalse(gen.isFlush());
		assertTrue(gen.isStraight());
	}

}
