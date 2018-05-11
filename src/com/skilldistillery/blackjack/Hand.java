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

	public boolean blackJackWin(List<Card> hand) {
		Rank firstDealerCard = hand.get(0).getRank();
		Rank secondDealerCard = hand.get(1).getRank();
		if ((firstDealerCard.equals(Rank.ACE)) || (firstDealerCard.equals(Rank.KING))
				|| (firstDealerCard.equals(Rank.QUEEN)) || (firstDealerCard.equals(Rank.JACK))
				|| (firstDealerCard.equals(Rank.TEN))) {
			if ((!secondDealerCard.equals(firstDealerCard.value)) && ((firstDealerCard.equals(Rank.ACE))
					|| (firstDealerCard.equals(Rank.KING)) || (firstDealerCard.equals(Rank.QUEEN))
					|| (firstDealerCard.equals(Rank.JACK)) || (firstDealerCard.equals(Rank.TEN)))) {
				String blackJackWin = "Blackjack!!";
				System.out.println(blackJackWin);
				return true;
			}
		} return false;
	}

}
