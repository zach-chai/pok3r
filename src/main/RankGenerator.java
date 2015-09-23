package main;

public class RankGenerator {
	
	private Hand hand;
	
	public RankGenerator(Hand hand) {
		this.hand = hand;
	}
	
//	public HandCardRank Generate() {
//		if(isRoyalFlush())
//			return HandCardRank.RoyalFlush;
//		else if(isStraightFlush())
//			return HandCardRank.StraightFlush;
//		return HandCardRank.HighCard;
//	}
//	
//	public boolean isRoyalFlush() {
//		
//	}
//	
//	public boolean isStraightFlush() {
//		
//	}
//	
//	public boolean isFourOfAKind() {
//		
//	}
//	
//	public boolean isFlush() {
//
//	}
	
	public boolean isOfMinimumKind(int kind) {
		if(kind < 1 || kind > 4) {
			return false;
		}
		
		int maxKind = 1;
		int currentKind = 1;
		for(int i = 0; i < hand.getCards().size(); i++) {
			for(int j = i + 1; j < hand.getCards().size(); j++) {
				if(hand.getCards().get(i).getValue().equals(hand.getCards().get(j).getValue())) {
					++currentKind;
				}
			}
			if(maxKind < currentKind)
				maxKind = currentKind;
			currentKind = 1;
		}
		return maxKind >= kind;
	}
	
	public boolean hasDuplicates() {
		return isOfMinimumKind(2);
	}

}
