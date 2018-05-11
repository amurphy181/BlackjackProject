package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	
	List<Card> playerHand = new ArrayList();
	Deck deckHolder = new Deck();
	
	public Hand() {
	}

	public int getHandValue() {
		return -1;
	}
	
	public void addCard() {
		playerHand.add(deckHolder.dealCard());
		playerHand.add(deckHolder.dealCard());
	}
	
	public void clearHand() {
		
	}
	
	public List<Card> getCards(){
		List<Card> cards = new ArrayList<>();
		return cards;
	}
	
	
}
