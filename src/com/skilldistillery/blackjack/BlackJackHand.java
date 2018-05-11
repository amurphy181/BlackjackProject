package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.List;

public class BlackJackHand {

	public BlackJackHand() {
	}
	static BlackJackHand blackJack = new BlackJackHand();
	
	public static void main(String[] args) {
		
		blackJack.run();

	}
	
	public void run() {
		Deck deck = new Deck();
		List<Card> playerHand = new ArrayList<>();
		List<Card> dealerHand = new ArrayList<>();
		
		deck.shuffle();
		
		Card cardCheck = deck.dealCard();
		
		
		playerHand.add(deck.dealCard());
		dealerHand.add(deck.dealCard());
		playerHand.add(deck.dealCard());
		dealerHand.add(deck.dealCard());
		
		System.out.println();
		
		
		
		System.out.println(cardCheck.toString());
		System.out.println(playerHand.toString());
		System.out.println(dealerHand.toString());
		
		
	}

}
