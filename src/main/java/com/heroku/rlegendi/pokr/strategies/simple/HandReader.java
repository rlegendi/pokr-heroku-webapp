package com.heroku.rlegendi.pokr.strategies.simple;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

/**
 * Simple utility class to parse the found CSV data about the odds.
 * 
 * @author rlegendi
 */
class HandReader {
	private static final int COL_HAND = 2;
	private static final int COL_DESC = 4;
	private static final int COL_PROB = 5;

	// TODO We may consider lazy init here
	public static List<Hand> readHands() {
		final ArrayList<Hand> ret = new ArrayList<>();

		CSVReader reader = null;
		try {
			reader = new CSVReader(new FileReader(new File(SimpleStrategy.class
					.getResource("/hands.csv").toURI())));

			for (final String[] data : reader.readAll()) {
				final String hand = data[COL_HAND];
				final String desc = data[COL_DESC];
				final double prob = Double.parseDouble(data[COL_PROB]);

				ret.add(new Hand(hand, desc, prob));
			}

			return Collections.unmodifiableList(ret);
		} catch (final IOException | URISyntaxException e) {
			throw new ExceptionInInitializerError(e);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (final IOException e) {
					throw new ExceptionInInitializerError(e);
				}
			}
		}
	}
}