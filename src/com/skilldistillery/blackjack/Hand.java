package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	
	List<Card> hand = new ArrayList<Card>();
	Deck deckHolder = new Deck();
	
	public Hand() {
	}

	public int getHandValue() {
		int handCount;
		for (Card card : hand) {
			Rank count = card.getRank();
		}
		return handCount;
	}
	
	public List<Card> addCard() {
		hand.add(deckHolder.dealCard());
		return hand;
	}
	
	public void clearHand() {
		hand = null;
	}
	
	public List<Card> getCards(){
		
		hand.add(deckHolder.dealCard());
		return hand;
	}
	
	
}
