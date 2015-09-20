package main;

public enum Suit {
	HEARTS, CLUBS, SPADES, DIAMONDS;
	
	public String toString() {
		String s = this.name();
		return s.substring(0, 1) + s.substring(1).toLowerCase();
	};
}