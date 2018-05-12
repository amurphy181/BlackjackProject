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
		List<Card> playerHand = new LinkedList<>();
		List<Card> dealerHand = new ArrayList<>();
		Hand actOnHands = new Hand();
		boolean gameContinue = true;
		Scanner input = new Scanner(System.in);

		boolean handContinue = true;

		while (gameContinue) {

			deck.shuffle();

			playerHand.add(deck.dealCard());
			dealerHand.add(deck.dealCard());
			playerHand.add(deck.dealCard());
			dealerHand.add(deck.dealCard());

			int phCount = actOnHands.getHandValue(playerHand);
			int dealerCount = actOnHands.getHandValue(dealerHand);

			if (dealerCount == 21 && dealerCount > phCount) {
				System.out.println("Dealer wins with a Blackjack!");
				handContinue = false;
			} else if (dealerCount == 21 && phCount == 21) {
				System.out.println("Two blackjacks, whoa! Push.");
				handContinue = false;
			} else if (phCount == 21) {
				System.out.println("Player Blackjack wins!");
				handContinue = false;
			}

			while (handContinue) {
				Card dealerCardShowing = dealerHand.get(1);
				System.out.println("Dealer is showing a " + dealerCardShowing);

				System.out.println("Player count: " + phCount + "\nPlayer hand: " + playerHand.toString());
				System.out.println("Hit or hold?");
				String userChoice = input.nextLine();
				int totalCardsInHand = 2;

				if ((userChoice.equals("Hit") || userChoice.equals("hit")) && (handContinue == true)) {
					// check for going over on an ace if the current player hand count is more than
					// 11
					// this is the part that needs to be fixed! bugs all over here
					if (phCount >= 11) {
						playerHand.addAll(actOnHands.addCard());
						int aceTracker = phCount + 11;
						phCount = actOnHands.getHandValue(playerHand);

						totalCardsInHand++;
						Card lastCardDealt = playerHand.get(totalCardsInHand - 1);
						System.out.println("Card dealt was a : " + lastCardDealt.toString());
						if ((phCount == aceTracker) && totalCardsInHand == 3) {

							phCount = phCount - 10;
						} else if ((phCount == aceTracker) && totalCardsInHand == 4) {
							phCount = phCount - 20;
						}
						if (phCount == 21) {
							System.out.println("Player has 21: will the dealer be able to match?");
							break;
						}
					} else {
						playerHand.addAll(actOnHands.addCard());
						phCount = actOnHands.getHandValue(playerHand);
					}

					// phCount = actOnHands.getHandValue(playerHand);
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

			while (dealerCount < 17 && phCount <= 21 && handContinue) {
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
			} else if (phCount == dealerCount) {
				System.out.println("Push.");
			}

			System.out.println("Dealer hand count: " + dealerCount);
			System.out.println("Player's hand: " + playerHand.toString());
			System.out.println("Dealer's hand: " + dealerHand.toString());

			System.out.print("Play again? Yes or no: ");

			String gameContinueChoice = input.nextLine();

			if (gameContinueChoice == "No" || gameContinueChoice == "no") {
				gameContinue = false;
			} else {
				continue;
			}

		}

	}

}
