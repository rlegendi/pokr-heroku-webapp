package com.heroku.rlegendi.pokr.strategies.simple;

import java.util.List;

/**
 * <b>An extremely simple</b> odds calculator.
 * 
 * <p>
 * It simply subtracts the initial probability of a hand form 100%. Very rough
 * approximation but for a proof of concept solution it should be enough.
 * </p>
 * 
 * <p>
 * It is implemented as a static utility class, thus the class is <b>not
 * instantiable</b>.
 * </p>
 * 
 * @author rlegendi
 */
public final class SimpleStrategy {
	private static final List<Hand> hands = HandReader.readHands();

	public static String simpleApproximation(final String deal) {
		for (final Hand act : hands) {
			if (act.hand.equals(deal)) {

				return "You have "
						+ act.desc
						+ ", its percentage to win is "
						+ String.format("%.2f%%",
								(100.0 - act.probabilityOfOccurrence));
			}
		}

		return "No hint availabe :-(";
	}

	private SimpleStrategy() {
		throw new IllegalStateException();
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}
