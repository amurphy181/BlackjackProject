package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	
	private List<Card> cards;
	
	public Deck() {
		cards = new ArrayList<>();
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				cards.add(new Card(r, s));
			}
		}
	}
	
	public int checkDeckSize() {
		return cards.size();
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	public Card dealCard() {
		Card dealtCard = cards.remove(0);
		return dealtCard;
		
	}
	
	public boolean checkCardRankForAce(List<Card> cards) {
		boolean aceCheck = false;
		for (Card card : cards) {
			if(card.getRank() == Rank.ACE) {
				aceCheck = true;
			}
		}
		return aceCheck; 
	}

}
