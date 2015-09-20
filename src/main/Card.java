package main;

public class Card {
	
	private Suit suit;
	private Value value;
	
	public Card() {
		this(Value.random(), Suit.random());
	}
	
	public Card(Value v, Suit s) {
		suit = s;
		value = v;
	}
	
	@Override
	public String toString() {
		return value.toString() + suit.toString();
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
