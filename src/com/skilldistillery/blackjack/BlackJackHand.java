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
		BlackJackModifiers bjm = new BlackJackModifiers();
		List<Card> playerHand = new ArrayList<>();
		List<Card> dealerHand = new ArrayList<>();
		Hand actOnHands = new Hand();
		boolean gameContinue = true;
		boolean handContinue = true;
		Scanner input = new Scanner(System.in);


		while (gameContinue) {
			
			if(deck.checkDeckSize() < 20) { // creates a new deck so that it will never run out, saving from NullPointerExceptions!
				deck = new Deck();
			}

			// shuffle, then add two cards each in dealing order (player first)
			deck.shuffle();
			playerHand = bjm.dealCardToPlayer(deck);
			dealerHand = bjm.dealCardToDealer(deck);
			playerHand = bjm.dealCardToPlayer(deck);
			dealerHand = bjm.dealCardToDealer(deck);
			deck.shuffle();
			
			// maintain a count of the rank value of each player's hand
			int playerCount = actOnHands.getHandValue(playerHand);
			int dealerCount = actOnHands.getHandValue(dealerHand);

			// determine whether one or both candidates got a blackjack and set the gameContinue boolean to that value
			gameContinue = bjm.initialBlackJackCheck(playerCount, dealerCount);
			handContinue = gameContinue;


			while (handContinue) {
				Card dealerCardShowing = dealerHand.get(1);
				System.out.println("Dealer is showing a " + dealerCardShowing + "\n");
				System.out.println("Player count: " + playerCount + "\nPlayer hand:\n" + actOnHands.printHand(playerHand));
				System.out.println("Hit or hold?");
				String userChoice = input.nextLine();
				
				// the player parts were fairly extensive, and so now reside in the BlackJackModifiers class
				handContinue = bjm.playerGamePlay(userChoice, handContinue, input);
				playerCount = actOnHands.getHandValue(playerHand);
				System.out.println("Player count: " + playerCount + "\nPlayer hand:\n" + actOnHands.printHand(playerHand));
				
				if(playerCount > 21) {
					gameContinue = false;
				}
				
			}
			
			// dealer comes back to play; short series of code

			while (dealerCount < 17 && playerCount <= 21 && gameContinue) {
				System.out.println("\nThe dealer is taking a card...\n");
				dealerHand.add(deck.dealCard());
				dealerCount = actOnHands.getHandValue(dealerHand);
				if (dealerCount > 21) {
					System.out.println("Dealer busts!");

				}
			}
			
			// this will print out the win conditions based on highest score or tied score
			bjm.winConditions(playerCount, dealerCount);

			// print outcome, hands
			bjm.finalOutcomePrintOut(playerCount, dealerCount);
			
			// take input after the prompt in the "finalOutcomePrintOut"
			String gameContinueChoice = input.nextLine();
			if (gameContinueChoice.equals("Yes") || gameContinueChoice.equals("yes")) {
				playerCount = 0;
				playerHand.clear();
				handContinue = true;
				dealerCount = 0;
				dealerHand.clear();
				gameContinue = true;
				// continue;
			} else {
				System.out.println("Thanks for playing at Kurmudgeon's Kasino! \nAnd remember, the house alllways wins.");
				input.close();
				System.exit(0);
			}

		}

	}

}
