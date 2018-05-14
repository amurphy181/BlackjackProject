package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BlackJackModifiers {

	public BlackJackModifiers() {
	}

	Deck deck = new Deck();
	List<Card> playerHand = new ArrayList<>();
	List<Card> dealerHand = new ArrayList<>();
	Hand actOnHands = new Hand();

	public List<Card> dealCardToPlayer(Deck deck) {
		deck.shuffle();

		playerHand.add(deck.dealCard());

		return playerHand;
	}

	public List<Card> dealCardToDealer(Deck deck) {
		dealerHand.add(deck.dealCard());
		return dealerHand;

	}

	public boolean playerGamePlay(String userChoice, boolean handContinue, Scanner input) {
		int totalCardsInHand = 2;
		int playerCount = actOnHands.getHandValue(playerHand);
		int dealerCount = actOnHands.getHandValue(dealerHand);

		if ((userChoice.equals("Hit") || userChoice.equals("hit")) && (handContinue == true) && playerCount < 11) {
			// check for going over on an ace if the current player hand count is more than
			// 11
			while (playerCount < 11 && handContinue) {
				playerHand.add(deck.dealCard());
				playerCount = actOnHands.getHandValue(playerHand);
				totalCardsInHand++;
				System.out.println("Player count: " + playerCount + "\nPlayer hand: " + playerHand.toString());
				System.out.println("\nHit again?");
				userChoice = input.nextLine();
				if ((userChoice.equals("hit") || userChoice.equals("Hit")) && playerCount < 11) {
					handContinue = true;
					continue;
				} else if ((userChoice.equals("hit") || userChoice.equals("Hit")) && playerCount >= 11) {
					break;
				} else if (userChoice.equals("Hold") || userChoice.equals("hold")) {
					handContinue = false;
					return handContinue;
				} else {
					handContinue = false;
					return handContinue;
				}
			}
		}

		if ((userChoice.equals("Hit") || userChoice.equals("hit")) && (handContinue == true) && playerCount >= 11) {

			while (playerCount >= 11 && handContinue) {
				deck.shuffle();
				playerHand.add(deck.dealCard());
				playerCount = actOnHands.getHandValue(playerHand);
				totalCardsInHand++;
				Card lastCardDealt = playerHand.get(totalCardsInHand - 1);
				System.out.println("Card dealt was a : " + lastCardDealt.toString());
				System.out.println("Your hand contains the following cards:\n " + actOnHands.printHand(playerHand));

				if (playerCount == 21) {
					System.out.println("Player has 21: will the dealer be able to match?");
					handContinue = false;
					return handContinue;
				} else if (playerCount > 21) {
					System.out.println("Bust! Hand stands at " + playerCount);
					handContinue = false;
					return handContinue;

				} else if (playerCount < 21) {
					System.out.println("Hit or hold? Your hand stands at " + playerCount);
					userChoice = input.nextLine();
					if (userChoice.equals("hit") || userChoice.equals("Hit")) {
						playerHand.add(deck.dealCard());
						playerCount = actOnHands.getHandValue(playerHand);
						totalCardsInHand++;
						lastCardDealt = playerHand.get(totalCardsInHand - 1);
						System.out.println("Card dealt was a : " + lastCardDealt.toString());
						input.nextLine();
						break;
					} else {
						handContinue = false;
						return handContinue;
					}
				}

			}
			// phCount = actOnHands.getHandValue(playerHand);
			System.out.println(playerCount);
			if (playerCount > 21) {
				System.out.println("Oooooohhhhh busteddddd, dealer wins");
				System.out.println("Dealer had a " + dealerCount);
				handContinue = false;
			}

		} else if (userChoice.equals("Hold") || userChoice.equals("hold"))

		{
			handContinue = false;
			return handContinue;
		}

		return handContinue;
	}

	public void winConditions(int playerCount, int dealerCount) {
		if (playerCount <= 21 && playerCount > dealerCount) {
			System.out.println("You win!");
		} else if (dealerCount <= 21 && playerCount < dealerCount) {
			System.out.println("Dealer wins this round");
		} else if (playerCount == dealerCount) {
			System.out.println("Push.");
		}
	}

	// checks out, works
	public boolean initialBlackJackCheck(int playerCount, int dealerCount) {
		boolean handContinue = true;
		if (dealerCount == 21 && dealerCount > playerCount) {
			System.out.println("Dealer wins with a Blackjack!");
			handContinue = false;
		} else if (dealerCount == 21 && playerCount == 21) {
			System.out.println("Two blackjacks, whoa! Push.");
			handContinue = false;
		} else if (playerCount == 21) {
			System.out.println("Player Blackjack wins!");
			handContinue = false;
		}
		return handContinue;
	}
	
	public void finalOutcomePrintOut(int playerCount, int dealerCount) {
		System.out.println("Player hand count: " + playerCount);
		System.out.println("Dealer hand count: " + dealerCount);
		System.out.println("\nYou finished the hand with the following cards:\n" + actOnHands.printHand(playerHand));
		System.out.println("The dealer finished the hand with the following cards:\n" + actOnHands.printHand(dealerHand));

		System.out.print("Play again? Yes or no: ");
	}
}
