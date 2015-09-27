import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Game {
	
	Round round;
	
	public Game() {
		round = new Round(new BufferedReader(new InputStreamReader(System.in)),
						new BufferedWriter(new OutputStreamWriter(System.out)));
	}
	
	public void startGame() {
		System.out.println("Welcome to Poker Ranking");
		do {
			startRound();
			System.out.println("Press 0 to play again or 1 to exit");
		} while (round.getInput().equals("0"));
		round.cleanup();
	}
	
	private void startRound() {
		round.setupRound();
		round.inputPlayerHands();
		round.rankPlayers();
		round.outputRanks();
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.startGame();
	}

}
