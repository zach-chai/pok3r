

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Player implements Comparable<Player> {
	
	private static final AtomicInteger players = new AtomicInteger(0);
	private final int id;
	private String name;
	private Hand hand;
	
	public Player() {
		this(new Hand());
	}
	
	public Player(Hand hand) {
		this(null, hand);
	}
	
	public Player(String name, Hand hand) {
		this.id = players.getAndIncrement();
		this.name = name;
		this.hand = hand;
	}
	
	public static Player getPlayerById(List<Player> players, int id) {
		for(Player p: players) {
			if(p.getId() == id) {
				return p;
			}
		}
		return null;
	}
	
	@Override
	public int compareTo(Player o) {
		return this.hand.getRank().compareTo(o.getHand().getRank());
	}
	
	public static void resetPlayers() {
		players.set(0);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

	public int getId() {
		return id;
	}

}
