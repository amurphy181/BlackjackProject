package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
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
			
			if(deck.checkDeckSize() < 40) {
				deck = new Deck();
			}

			// shuffle, then add two cards each in dealing order (player first)
			deck.shuffle();
			playerHand = bjm.dealCardToPlayer(deck);
			dealerHand = bjm.dealCardToDealer(deck);
			playerHand = bjm.dealCardToPlayer(deck);
			dealerHand = bjm.dealCardToDealer(deck);

			deck.shuffle();
			
			System.out.println("Deck length, post-deal: " + deck.checkDeckSize());

			// maintain a count of the rank value of each player's hand
			int playerCount = actOnHands.getHandValue(playerHand);
			int dealerCount = actOnHands.getHandValue(dealerHand);

			// determine whether one or both candidates got a blackjack and set the gameContinue boolean to that value
			gameContinue = bjm.initialBlackJackCheck(playerCount, dealerCount);
			handContinue = gameContinue;


			while (handContinue) {
				Card dealerCardShowing = dealerHand.get(1);
				System.out.println("Dealer is showing a " + dealerCardShowing);

				System.out.println("Player count: " + playerCount + "\nPlayer hand: " + playerHand.toString());
				System.out.println("Hit or hold?");
				String userChoice = input.nextLine();
				
				// see if we can't get this to a different class
				handContinue = bjm.playerGamePlay(userChoice, handContinue, input);
				playerCount = actOnHands.getHandValue(playerHand);
				System.out.println("Player count: " + playerCount + "\nPlayer hand: " + playerHand.toString());
				
				
				if(playerCount > 21) {
					gameContinue = false;
				}
				
			}

			while (dealerCount < 17 && playerCount <= 21 && gameContinue) {
				dealerHand.add(deck.dealCard());
				dealerCount = actOnHands.getHandValue(dealerHand);
				if (actOnHands.checkCardRankForAce(dealerHand) >= 1) {
					int totalAces = actOnHands.checkCardRankForAce(dealerHand);
					if (dealerCount > 21) {
						dealerCount = dealerCount - ((totalAces - 1) * 10); // take one ace off, test to see if still above 21
						totalAces--;  
						if (dealerCount > 21) {
							dealerCount = dealerCount - ((totalAces - 1) * 10); 
							totalAces--;  
						}
					}
					break;
				}
				if (dealerCount > 21) {
					System.out.println("Dealer busts!");

				}
			}
			
			bjm.winConditions(playerCount, dealerCount);


			System.out.println("\nPlayer hand count: " + playerCount);
			System.out.println("Dealer hand count: " + dealerCount);
			System.out.println("Player's hand: " + playerHand.toString());
			System.out.println("Dealer's hand: " + dealerHand.toString());

			System.out.print("Play again? Yes or no: ");

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
				System.out.println("Thanks for playing! Remember, the house always wins.");
				System.exit(0);
			}

		}

	}

}
