package com.skilldistillery.blackjack.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.skilldistillery.blackjack.Card;
import com.skilldistillery.blackjack.Deck;

public class DeckTests {
	
	Deck d;

	@Before
	public void setUp() throws Exception {
		d = new Deck();
	}

	@After
	public void tearDown() throws Exception {
		d = null;
	}

	@Test
	public void test_deck_size_is_52() {
		assertEquals(52, d.checkDeckSize());
	}
	
	@Test
	public void test_deal_card_returns_card() {
		
	}

}
