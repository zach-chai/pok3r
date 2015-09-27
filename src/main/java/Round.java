

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Round {
	
	private BufferedReader console;
	private List<Player> players;
	private int num;
	
	public Round(BufferedReader input) {
		this.console = input;
	}
	
	public void setupRound() {
		do {
			System.out.println("Enter number of players for this round");
			try {
				num = Integer.parseInt(getInput());
				System.out.println(num);
			} catch (Exception e) {
			}
		} while(num < 2 || num > 4);
		
		this.players = new ArrayList<Player>();
		Player p;
		for(int i = 0; i < num; ++i) {
			p = new Player();
			players.add(p);
			System.out.println("Player created and given id " + p.getId());
		}
	}
	
	public void inputPlayerHands() {
		String input = "";
		Player player = null;
		String[] tokens;
		boolean failed;
		for(int i = 0; i < players.size(); ++i) {
			do {
				System.out.println(String.format("Enter hand %d remaining", players.size() - i));
				try {
					input = getInput();
					tokens = input.split(" ");
					player = Player.getPlayerById(players, Integer.parseInt(tokens[0]));
					if(player.getHand().getCards().size() == 5) {
						throw new IllegalArgumentException("player already has cards");
					}
					player.setHand(new Hand(Arrays.copyOfRange(tokens, 1, tokens.length)));
					System.out.println(player.getHand().getCards().size());
					failed = player.getHand().getCards().size() != 5;
				} catch (Exception e) {
					e.printStackTrace();
					failed = true;
				}
				System.out.println(failed);
			} while (failed);
		}
	}
	
	public void rankPlayers() {
		System.out.println("Ranking Players...");
		for(Player player: players) {
			player.getHand().generateRank();
		}
		Collections.sort(players);
		Collections.reverse(players);
		System.out.println("done.");
	}
	
	public void outputRanks() {
		String output;
		int i = 0;
		for(Player player: players) {
			output = String.format("%d %s %d", player.getId(), player.getHand().toString(), ++i);
			System.out.println(output);
		}
	}
	
	public String getInput() {
		try {
			return console.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void closeInput() {
		try {
			console.close();
		} catch (IOException e) {
			System.out.println("Could not close input");
		}
	}
	
	public void softResetData() {
		players.clear();
	}
	
	public void hardResetData() {
		softResetData();
		Player.resetPlayers();
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
}
