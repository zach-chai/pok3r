package main;

public enum Value {
	ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN,
	EIGHT, NINE, TEN, JACK, QUEEN, KING;
	
	public String toString() {
		String s = this.name();
		return s.substring(0, 1) + s.substring(1).toLowerCase();
	};
}
