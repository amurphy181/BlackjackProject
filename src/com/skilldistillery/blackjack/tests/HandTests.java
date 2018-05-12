package com.skilldistillery.blackjack.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.skilldistillery.blackjack.Card;
import com.skilldistillery.blackjack.Hand;
import com.skilldistillery.blackjack.Rank;

public class HandTests {
	
	Hand h;

	@Before
	public void setUp() throws Exception {
		h = new Hand();
	}

	@After
	public void tearDown() throws Exception {
		h = null;
	}

	@Test
	public void test_for_blackjack_win() {
		
		fail("Not yet implemented");
	}

}
