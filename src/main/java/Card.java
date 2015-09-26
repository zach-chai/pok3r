

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
	
	public Card(String card) {
		int index = Utilities.lastCapitalIndex(card);
		String value_str = card.substring(0, index);
		String suit_str = card.substring(index);
		
		for(Value value: Value.values()) {
			if(value_str.equals(value.toString())) {
				this.value = value;
				break;
			}
		}
		for(Suit suit: Suit.values()) {
			if(suit_str.equals(suit.toString())) {
				this.suit = suit;
				break;
			}
		}
		if(this.value == null || this.suit == null) {
			throw new IllegalArgumentException(card);
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Card))
			return false;
		Card card = (Card) obj;
		if(this.value.equals(card.getValue()) && this.suit.equals(card.getSuit())) {
			return true;
		}
		return false;
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
