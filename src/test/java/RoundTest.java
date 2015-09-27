
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PipedReader;
import java.io.PipedWriter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RoundTest {

	BufferedReader mockReader;
	BufferedReader reader;
	Round round1;
	
	@Before
	public void setUp() throws Exception {
		mockReader = mock(BufferedReader.class);
		PipedInputStream pipeInput = new PipedInputStream();
	    reader = new BufferedReader(new InputStreamReader(pipeInput));
	    BufferedWriter mockWriter = new BufferedWriter(new OutputStreamWriter(new PipedOutputStream(pipeInput)));
		round1 = new Round(mockReader, mockWriter);
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
		assertEquals("Enter number of players for this round", reader.readLine());
		assertEquals("Player created and given id 0", reader.readLine());
		assertEquals("Player created and given id 1", reader.readLine());
		assertEquals("Player created and given id 2", reader.readLine());

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
		assertEquals("Enter hand 3 remaining", reader.readLine());
		assertEquals("Enter hand 2 remaining", reader.readLine());
		assertEquals("Enter hand 1 remaining", reader.readLine());
		
		round1.rankPlayers();
		assertEquals(HandCardRank.TwoPair, p1.getHand().getRank().getHandRank());
		assertEquals(HandCardRank.Straight, p3.getHand().getRank().getHandRank());
		assertEquals(HandCardRank.HighCard, p2.getHand().getRank().getHandRank());
		assertEquals(p3, round1.getPlayers().get(0));
		assertEquals(p1, round1.getPlayers().get(1));
		assertEquals(p2, round1.getPlayers().get(2));
		assertEquals("Ranking Players...", reader.readLine());
		assertEquals("Done.", reader.readLine());
		
		round1.outputRanks();
		assertEquals("Rank 1 -- Player Id 2 -- KingDiamonds TenSpades JackClubs QueenHearts NineHearts", reader.readLine());
		assertEquals("Rank 2 -- Player Id 0 -- FourSpades FourHearts SevenClubs SevenDiamonds KingSpades", reader.readLine());
		assertEquals("Rank 3 -- Player Id 1 -- AceHearts ThreeSpades NineClubs JackDiamonds SixClubs", reader.readLine());
	}
	
	@Test
	public void testSetupRound() throws Exception {
		when(mockReader.readLine())
		// invalid - bad input
		.thenReturn("g")
		// invalid - not enough players
		.thenReturn("1")
		// invalid - too many players
		.thenReturn("5")
		// valid
		.thenReturn("2");
		round1.setupRound();
		assertEquals(2, round1.getPlayers().size());
	}
	
	@Test
	public void testInputPlayerHands() throws Exception {
		when(mockReader.readLine()).thenReturn("2");
		round1.setupRound();

		when(mockReader.readLine())
		// invalid - bad input
		.thenReturn("RandomText")
		// invalid - missing player id
		.thenReturn("AceHearts ThreeSpades NineClubs JackDiamonds SixClubs")
		// invalid - only 4 cards
		.thenReturn("1 AceHearts ThreeSpades NineClubs JackDiamonds")
		// invalid - player id
		.thenReturn("3 AceHearts ThreeSpades NineClubs JackDiamonds SixClubs")
		// valid
		.thenReturn("1 AceHearts ThreeSpades NineClubs JackDiamonds SixClubs")
		// invalid - player already entered cards
		.thenReturn("1 KingDiamonds TenSpades JackClubs QueenHearts NineHearts")
		//valid
		.thenReturn("0 FourSpades FourHearts SevenClubs SevenDiamonds KingSpades");
		round1.inputPlayerHands();
		Player p1 = Player.getPlayerById(round1.getPlayers(), 0);
		Player p2 = Player.getPlayerById(round1.getPlayers(), 1);
		assertEquals(5, p1.getHand().getCards().size());
		assertTrue(p2.getHand().getCards().contains(new Card("AceHearts")));
		assertEquals(5, p2.getHand().getCards().size());
	}
	
	@Test
	public void testRankPlayers() throws Exception {
		when(mockReader.readLine()).thenReturn("2");
		round1.setupRound();

		when(mockReader.readLine())
		.thenReturn("0 AceHearts ThreeSpades NineClubs JackDiamonds SixClubs")
		.thenReturn("1 FourSpades FourHearts SevenClubs SevenDiamonds KingSpades");
		
		round1.inputPlayerHands();
		Player p1 = Player.getPlayerById(round1.getPlayers(), 0);
		Player p2 = Player.getPlayerById(round1.getPlayers(), 1);
		
		round1.rankPlayers();
		assertEquals(HandCardRank.HighCard, p1.getHand().getRank().getHandRank());
		assertEquals(HandCardRank.TwoPair, p2.getHand().getRank().getHandRank());
		// ensure the order is correct
		assertEquals(p1, round1.getPlayers().get(1));
		assertEquals(p2, round1.getPlayers().get(0));
	}
	
	@Test
	public void testRoundOutput() throws Exception {
		when(mockReader.readLine()).thenReturn("2");
		round1.setupRound();

		when(mockReader.readLine())
		.thenReturn("0 AceHearts ThreeSpades NineClubs JackDiamonds SixClubs")
		.thenReturn("1 FourSpades FourHearts SevenClubs SevenDiamonds KingSpades");
		
		round1.inputPlayerHands();
		
		round1.rankPlayers();
		round1.outputRanks();
		// check all output
		assertEquals("Enter number of players for this round", reader.readLine());
		assertEquals("Player created and given id 0", reader.readLine());
		assertEquals("Player created and given id 1", reader.readLine());
		assertEquals("Enter hand 2 remaining", reader.readLine());
		assertEquals("Enter hand 1 remaining", reader.readLine());
		assertEquals("Ranking Players...", reader.readLine());
		assertEquals("Done.", reader.readLine());
		assertEquals("Rank 1 -- Player Id 1 -- FourSpades FourHearts SevenClubs SevenDiamonds KingSpades", reader.readLine());
		assertEquals("Rank 2 -- Player Id 0 -- AceHearts ThreeSpades NineClubs JackDiamonds SixClubs", reader.readLine());
		
	}

}
