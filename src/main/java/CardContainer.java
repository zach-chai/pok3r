

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CardContainer {
	
	protected List<Card> cards;
	
	public CardContainer() {
		cards = new ArrayList<Card>();
	}
	
	public CardContainer(Card[] cards) {
		this.cards = new ArrayList<Card>(Arrays.asList(cards));
	}
	
	public void remove(Card card){
		cards.remove(card);
	}
	
	public void add(Card card){
		cards.add(card);
	}
	
	public boolean containsValue(Value value) {
		for(Card card: cards) {
			if(card.getValue() == value) {
				return true;
			}
		}
		return false;
	}
	
	public Card getHighCard() {
		Card highCard = cards.get(0);
		for(Card card: cards) {
			if(card.getValue().compareTo(highCard.getValue()) > 0) {
				highCard = card;
			}
		}
		return highCard;
	}
	
	@Override
	public String toString() {
		String str = "";
		for(Card card: cards) {
			str += card.toString()+" ";
		}
		return str.substring(0, str.length() - 1);
	}

	public List<Card> getCards() {
		return cards;
	}

}
