package main;

public class HandRank implements Comparable<HandRank> {

	private HandCardRank handRank;
	private Card highCard;
	
	public HandRank(HandCardRank handRank, Card highCard) {
		this.handRank = handRank;
		this.highCard = highCard;
	}
	
	@Override
	public int compareTo(HandRank o) {
		int rankComparison = this.handRank.compareTo(o.handRank); 
		if (rankComparison == 0) {
			return highCard.getValue().compareTo(o.getHighCard().getValue());
		}
		return rankComparison;	
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	public HandCardRank getHandRank() {
		return handRank;
	}
	public void setHandRank(HandCardRank handRank) {
		this.handRank = handRank;
	}
	public Card getHighCard() {
		return highCard;
	}
	public void setHighCard(Card highCard) {
		this.highCard = highCard;
	}
	
}
