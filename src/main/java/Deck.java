

public class Deck extends CardContainer {

	public Deck() {
		loadDeck();
	}
	
	public void loadDeck() {
		cards.clear();
		for(Value value: Value.values()) {
			for(Suit suit: Suit.values()) {
				cards.add(new Card(value, suit));
			}
		}
	}
}
