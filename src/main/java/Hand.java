

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
	
	public void generateRank() {
		RankGenerator rg = new RankGenerator(this);
		rank = new HandRank(rg.Generate(), this.getHighCard());
	}

	public HandRank getRank() {
		return rank;
	}
}
