package com.heroku.rlegendi.pokr.strategies.simple;

import java.util.List;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class HandReaderTest {
	private static final List<Hand> hands = HandReader.readHands();

	@Test
	public void testReadingRf() {
		final Hand h = hands.get(0);

		assertEquals("AKQJT", h.hand);
		assertEquals("Royal Flush", h.desc);
		assertEquals(0.0015, h.probabilityOfOccurrence, 1E-4);
	}

	@Test
	public void testReadingFourAces() {
		final Hand h = hands.get(15);

		assertEquals("AAAA8", h.hand);
		assertEquals("Four Aces", h.desc);
		assertEquals(0.0240, h.probabilityOfOccurrence, 1E-4);
	}
}
