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
//	public boolean isFullHouse() {
//		
//	}
	
	public boolean isFlush() {
		Suit suit = hand.getCards().get(0).getSuit();
		for(int i = 1; i < hand.getCards().size(); i++) {
			if(!hand.getCards().get(i).getSuit().equals(suit)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isStraight() {
		Card minCard = hand.getCards().get(0);
		boolean hasNextCard = false;
		for(int i = 1; i < hand.getCards().size(); i++) {
			if(hand.getCards().get(i).getValue().compareTo(minCard.getValue()) < 0) {
				minCard = hand.getCards().get(i);
			}
		}
		for(int i = 1; i < hand.getCards().size(); i++) {
			hasNextCard = false;
			for(int j = 0; i < hand.getCards().size(); i++) {
				if(hand.getCards().get(j).getValue().ordinal() == minCard.getValue().ordinal() + i) {
					hasNextCard = true;
				}
			}
			if(!hasNextCard) {
				return false;
			}
		}
		return true;
	}
	
	public boolean hasKind(int kind) {
		if(kind < 1 || kind > 4) {
			return false;
		}
	
		int currentKind = 1;
		for(int i = 0; i < hand.getCards().size(); i++) {
			for(int j = 0; j < hand.getCards().size(); j++) {
				if(i == j) {
					continue;
				}
				if(hand.getCards().get(i).getValue().equals(hand.getCards().get(j).getValue())) {
					++currentKind;
				}
			}
			if(currentKind == kind)
				return true;
			currentKind = 1;
		}
		return false;
	}
	
	public boolean isOfMinimumKind(int kind) {
		if(kind < 1) {
			return false;
		}
		for(int i = 0; i < 5 - kind; i++) {
			if(hasKind(kind + i)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean hasDuplicates() {
		return isOfMinimumKind(2);
	}

}
