package main;

public class Card {
	
	private Suit suit;
	private Value value;
	
	public Card(Value v, Suit s) {
		suit = s;
		value = v;
	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	public Value getValue() {
		return value;
	}

	public void setValue(Value value) {
		this.value = value;
	}
	
}
