package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
	
	public boolean hasFlush() {
		Suit suit = hand.getCards().get(0).getSuit();
		for(int i = 1; i < hand.getCards().size(); i++) {
			if(!hand.getCards().get(i).getSuit().equals(suit)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean hasStraight() {
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
	
	public boolean hasTwoPair() {
		List<Integer> kinds = getKinds();
		Collections.sort(kinds);
		return kinds.get(1) == 2 && kinds.get(2) == 2;
	}
	
	public boolean hasOnePair() {
		return hasKind(2);
	}
	
	public List<Integer> getKinds() {
		List<Integer> kinds = new ArrayList<Integer>();
		List<Value> checked = new ArrayList<Value>();
		int currentKind = 1;
		for(int i = 0; i < hand.getCards().size(); i++) {
			if(checked.contains(hand.getCards().get(i).getValue())) {
				continue;
			}
			for(int j = 0; j < hand.getCards().size(); j++) {
				if(i == j) {
					continue;
				}
				if(hand.getCards().get(i).getValue().equals(hand.getCards().get(j).getValue())) {
					++currentKind;
				}
			}
			checked.add(hand.getCards().get(i).getValue());
			kinds.add(currentKind);
			currentKind = 1;
		}
		return kinds;
	}
	
	public boolean hasKind(int kind) {
		if(kind < 1 || kind > 4) {
			return false;
		}
		
		return getKinds().contains(kind);
	}
	
	public boolean isOfMinimumKind(int kind) {
		if(kind < 1) {
			return false;
		}
		List<Integer> kinds = getKinds(); 
		for(int i = 0; i < 5 - kind; i++) {
			if(kinds.contains(kind + i)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean hasDuplicates() {
		return isOfMinimumKind(2);
	}

}
