package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {

	List<Card> hand = new ArrayList<Card>();
	Deck deckHolder = new Deck();

	public Hand() {
	}

	public int getHandValue(List<Card> hand) {
		int handCount = 0;
		for (Card card : hand) {
			handCount = handCount + card.getRank().getRank();
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

	public List<Card> getCards() {

		hand.add(deckHolder.dealCard());
		return hand;
	}
	
	public int checkCardRankForAce(List<Card> hand) {
		int aceCheck = 0;
		for (Card card : hand) {
			if(card.getRank() == Rank.ACE) {
				aceCheck++;
			}
		}
		return aceCheck; 
	}


}
