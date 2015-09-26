package main;

public class Hand extends CardContainer {

	private HandRank rank;
	
	public Hand() {
		super();
	}
	
	public Hand(Card[] cards) {
		super(cards);
	}
	
	public Hand(String[] cards) {
		for(String str: cards) {
			this.cards.add(new Card(str));
		}
	}

	public HandRank getRank() {
		return rank;
	}
}
