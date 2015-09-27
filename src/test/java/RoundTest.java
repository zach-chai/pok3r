
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.BufferedReader;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RoundTest {

	BufferedReader mockReader;
	Round round1;
	
	@Before
	public void setUp() throws Exception {
		mockReader = mock(BufferedReader.class);
		round1 = new Round(mockReader);
	}

	@After
	public void tearDown() throws Exception {
		round1.hardResetData();
	}

	@Test
	public void testRound() throws Exception {
		when(mockReader.readLine()).thenReturn("3");
		round1.setupRound();
		assertEquals(3, round1.getPlayers().size());

		when(mockReader.readLine())
		.thenReturn("1 AceHearts ThreeSpades NineClubs JackDiamonds SixClubs")
		.thenReturn("2 KingDiamonds TenSpades JackClubs QueenHearts NineHearts")
		.thenReturn("0 FourSpades FourHearts SevenClubs SevenDiamonds KingSpades");
		
		round1.inputPlayerHands();
		Player p1 = Player.getPlayerById(round1.getPlayers(), 0);
		Player p2 = Player.getPlayerById(round1.getPlayers(), 1);
		Player p3 = Player.getPlayerById(round1.getPlayers(), 2);
		assertEquals(5, p1.getHand().getCards().size());
		assertEquals(5, p2.getHand().getCards().size());
		assertEquals(5, p3.getHand().getCards().size());
		
		round1.rankPlayers();
		assertEquals(HandCardRank.TwoPair, p1.getHand().getRank().getHandRank());
		assertEquals(HandCardRank.Straight, p3.getHand().getRank().getHandRank());
		assertEquals(HandCardRank.HighCard, p2.getHand().getRank().getHandRank());
		assertEquals(p3, round1.getPlayers().get(0));
		assertEquals(p1, round1.getPlayers().get(1));
		assertEquals(p2, round1.getPlayers().get(2));
	}

}
