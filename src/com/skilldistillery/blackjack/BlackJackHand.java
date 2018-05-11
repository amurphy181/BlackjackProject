package com.skilldistillery.blackjack;

public class BlackJackHand {

	public BlackJackHand() {
	}
	static BlackJackHand blackJack = new BlackJackHand();
	
	public static void main(String[] args) {
		
		blackJack.run();

	}
	
	public void run() {
		Deck deck = new Deck();
		
		deck.shuffle();
		
		Card cardCheck = deck.dealCard();
		System.out.println(cardCheck.toString());
	}

}
