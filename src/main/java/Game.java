import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Game {

	public static void main(String[] args) {
		System.out.println("Welcome to Poker Ranking");
		
		Round round = new Round(new BufferedReader(new InputStreamReader(System.in)), new BufferedWriter(new OutputStreamWriter(System.out)));
		round.setupRound();
		round.inputPlayerHands();
		round.rankPlayers();
		round.outputRanks();
	}

}
