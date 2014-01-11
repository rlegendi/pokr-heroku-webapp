package com.heroku.rlegendi.pokr;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.heroku.rlegendi.pokr.strategies.simple.SimpleStrategy;

/**
 * Root webservice implementation.
 * 
 * @author rlegendi
 */
@Path("/pokr")
public class Pokr {
	protected static final String VERSION = "1.0RC1";

	/**
	 * Dummy service to test availability and return current version number.
	 * 
	 * @return the current version number of the webservice
	 */
	@GET
	@Path("/version")
	@Produces(MediaType.TEXT_PLAIN)
	public String version() {
		return VERSION;
	}

	/**
	 * Simple approximation method.
	 * 
	 * @param hand
	 *            the user hand as a simple string, e.g. <code>"AJDK9"</code>
	 * @return a serialized Hint object created by the strategy; <i>cannot be
	 *         null</i>
	 */
	@GET
	@Path("/holdemSimple/{hand}")
	@Produces(MediaType.APPLICATION_JSON)
	public Hint holdemSimpleApproximation(@PathParam("hand") final String hand) {
		final String message = SimpleStrategy.simpleApproximation(hand);

		return new Hint(message);
	}

	/**
	 * For further usage: data could be stored to apply AI methods (machine
	 * learning or evolutionary algorithms) for better odds calculation.
	 * 
	 * @param hand
	 *            the user hand as a simple string, e.g. <code>"AJDK9"</code>
	 * @param moneyWon
	 *            the amount of money the user won, <i>must be positive</i>
	 * @param moneyLost
	 *            the amount of money the user lost, <i>must be positive</i>
	 */
	@GET
	@Path("/log/{hand}/{moneyWon}/{moneyLost}")
	public void log(@PathParam("hand") final String hand,
			@PathParam("moneyWon") final long moneyWon,
			@PathParam("moneyLost") final long moneyLost) {
		throw new UnsupportedOperationException("Yet to be implemented");
	}
}
