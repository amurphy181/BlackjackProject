package com.skilldistillery.blackjack.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.skilldistillery.blackjack.BlackJackModifiers;

public class BlackJackModifiersTests {
	
	BlackJackModifiers bjm;

	@Before
	public void setUp() throws Exception {
		bjm = new BlackJackModifiers();
	}

	@After
	public void tearDown() throws Exception {
		bjm = null;
	}
	
	@Test
	public void test_for_initial_blackjack() {
		
		assertEquals(false, bjm.initialBlackJackCheck(18, 21));
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
