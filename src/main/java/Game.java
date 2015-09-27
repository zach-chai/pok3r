import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Game {

	public static void main(String[] args) {
		System.out.println("Welcome to Poker Ranking");
		
		Round round = new Round(new BufferedReader(new InputStreamReader(System.in)));
		round.setupRound();
		round.inputPlayerHands();
		round.rankPlayers();
		round.outputRanks();
	}

}
