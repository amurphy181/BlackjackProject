package com.skilldistillery.blackjack;

public enum Suit {

	SPADES("spades"), CLUBS("clubs"), DIAMONDS("diamonds"), HEARTS("hearts");

	private String name;

	private Suit(String suit) {
		this.name = suit;
	}

	public String getSuit() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}

}
