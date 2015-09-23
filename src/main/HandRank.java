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
	
	public HandCardRank getHandRank() {
		return handRank;
	}
	public Card getHighCard() {
		return highCard;
	}
	
}
