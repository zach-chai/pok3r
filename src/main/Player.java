package main;

import java.util.concurrent.atomic.AtomicInteger;

public class Player {
	
	private static final AtomicInteger players = new AtomicInteger(0);
	private final int id;
	private String name;
	private Hand hand;
	
	public Player() {
		this(null, new Hand());
	}
	
	public Player(String name, Hand hand) {
		this.id = players.getAndIncrement();
		this.name = name;
		this.hand = hand;
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
