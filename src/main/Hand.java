package main;

public class Hand extends CardContainer {

	private HandRank rank;
	
	public Hand() {
		super();
	}
	
	public Hand(Card[] cards) {
		super(cards);
	}
	
	public Hand(String s1, String s2, String s3, String s4, String s5) {
		// TODO needs implementation
	}

	public HandRank getRank() {
		return rank;
	}
}
