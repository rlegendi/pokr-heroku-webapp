package com.heroku.rlegendi.pokr.strategies.simple;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SimpleStrategyTest {
	@Test
	public void testAcesFullOfKings() {
		final String chance = SimpleStrategy.simpleApproximation("AAAKK");
		assertEquals(
				"You have Aces Full over Kings, its percentage to win is 99,86%",
				chance);
	}

	@Test
	public void testPairOfAces() {
		final String chance = SimpleStrategy.simpleApproximation("AAKQJ");
		assertEquals("You have Pair of Aces, its percentage to win is 57,75%",
				chance);
	}
}
