package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CardContainer {
	
	private List<Card> cards;
	
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

	public List<Card> getCards() {
		return cards;
	}

}
