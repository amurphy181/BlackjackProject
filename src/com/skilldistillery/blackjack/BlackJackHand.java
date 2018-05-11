package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
		Hand actOnHands = new Hand();
		
		deck.shuffle();
		
		
		playerHand.add(deck.dealCard());
		dealerHand.add(deck.dealCard());
		playerHand.add(deck.dealCard());
		dealerHand.add(deck.dealCard());
		
		
		int phCount = actOnHands.getHandValue(playerHand);
		int dealerCount = actOnHands.getHandValue(dealerHand);
		System.out.println("Player count: " + phCount);
		System.out.println("Hit or hold?");
		Scanner input = new Scanner(System.in);
		String userChoice = input.nextLine();
		
		if(dealerCount == 21) {
			System.out.println("Dealer wins!");
		}
		if(userChoice.equals("Hit") || userChoice.equals("hit")) {
			playerHand.addAll(actOnHands.addCard());
			phCount = actOnHands.getHandValue(playerHand);
			System.out.println(phCount);
		} else if (userChoice.equals("Hold") || userChoice.equals("hold")) {
			
		}
		
		
		
		System.out.println("Player's hand: " + playerHand.toString());
		System.out.println("Dealer's hand: " + dealerHand.toString());
		
		
	}

}
