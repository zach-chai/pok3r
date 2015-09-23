package main;

public class Hand extends CardContainer {

	private HandRank rank;
	
	public Hand() {
		super();
	}
	
	public Hand(Card[] cards) {
		super(cards);
	}

	public HandRank getRank() {
		return rank;
	}
}
