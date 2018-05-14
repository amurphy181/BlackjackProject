package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {

	List<Card> hand = new ArrayList<Card>();
	Deck deckHolder = new Deck();

	public Hand() {
	}
	
	public StringBuilder printHand(List<Card> hand) {
		StringBuilder printedHand = new StringBuilder();
		for (Card card : hand) {
			printedHand.append(card.toString() + "\n");
		}
		
		return printedHand;
	}

	public int getHandValue(List<Card> hand) {
		int handCount = 0;
		for (Card card : hand) {
			handCount = handCount + card.getRank().getRank();
		}
		int aceCheck = checkCardRankForAce(hand);
		
		if (handCount > 21 && aceCheck > 0) {
			handCount = handCount - ((aceCheck - 1) * 10); // take one ace off, test to see if still above 21
			aceCheck--;
			if (handCount > 21 && aceCheck > 0) {
				handCount = handCount - ((aceCheck - 1) * 10);
				aceCheck--;
				if (handCount > 21 && aceCheck > 0) {
					handCount = handCount - ((aceCheck - 1) * 10);
					aceCheck--;
					if (handCount > 21 && aceCheck > 0) {
						handCount = handCount - ((aceCheck - 1) * 10);
						aceCheck--;
					}
				}
			}
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
			if (card.getRank() == Rank.ACE) {
				aceCheck++;
			}
		}
		return aceCheck;
	}

}
