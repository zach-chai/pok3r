package main;

import java.util.Random;

public enum Suit {
	HEARTS, CLUBS, SPADES, DIAMONDS;
	
	public static Suit random() {
		return Suit.values()[new Random().nextInt(Suit.values().length)];
	}
	
	public String toString() {
		String s = this.name();
		return s.substring(0, 1) + s.substring(1).toLowerCase();
	};
}