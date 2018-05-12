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
		boolean handContinue = true;

		if (dealerCount == 21) {
			System.out.println("Dealer wins with a Blackjack!");
			handContinue = false;
		}

		while (handContinue) {
			Card dealerCardShowing = dealerHand.get(1);
			System.out.println("Dealer is showing a " + dealerCardShowing);

			System.out.println("Player count: " + phCount + " with a hand of " + playerHand.get(0) + " and " + playerHand.get(1));
			System.out.println("Hit or hold?");
			Scanner input = new Scanner(System.in);
			String userChoice = input.nextLine();
			int totalCardsInHand = 2;

			if ((userChoice.equals("Hit") || userChoice.equals("hit")) && (handContinue == true)) {
				// check for going over on an ace if the current player hand count is more than 11
				// this is the part that needs to be fixed! bugs all over here
				if (phCount >= 11) {
					playerHand.addAll(actOnHands.addCard());
					Card lastCardDealt = playerHand.get(totalCardsInHand);
					if (lastCardDealt.getRank() == Rank.ACE) {
						phCount = phCount - 10;
					}
				} else {
					playerHand.addAll(actOnHands.addCard());
					phCount = actOnHands.getHandValue(playerHand);
				}

				phCount = actOnHands.getHandValue(playerHand);
				System.out.println(phCount);
				if (phCount > 21) {
					System.out.println("Oooooohhhhh busteddddd, dealer wins");
					System.out.println("Dealer had a " + dealerCount);
					handContinue = false;
				}

			} else if (userChoice.equals("Hold") || userChoice.equals("hold")) {
				break;
			}
		}

			while (dealerCount < 17 && phCount <= 21) {
				dealerHand.add(deck.dealCard());
				dealerCount = actOnHands.getHandValue(dealerHand);
				if (dealerCount > 21) {
					System.out.println("Dealer busts!");

				}
			}
			
			if (phCount <= 21 && phCount > dealerCount) {
				System.out.println("You win!");
			} else if (dealerCount <= 21 && phCount < dealerCount) {
				System.out.println("Dealer wins, womp");
			} else if (phCount == dealerCount){
				System.out.println("Push.");
			}

		

		System.out.println("Dealer hand count: " + dealerCount);
		System.out.println("Player's hand: " + playerHand.toString());
		System.out.println("Dealer's hand: " + dealerHand.toString());

	}

}
