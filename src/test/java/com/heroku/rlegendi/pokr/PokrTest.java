package com.heroku.rlegendi.pokr;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import com.heroku.rlegendi.pokr.Pokr;

/**
 * Elementary tests for the published <i>pokr</i> webservice.
 * 
 * @author rlegendi
 */
public class PokrTest extends JerseyTest {
	@Override
	protected Application configure() {
		return new ResourceConfig(Pokr.class);
	}

	@Test
	public void testVersionAsDummyVerification() {
		final String responseMsg = target().path("pokr/version").request()
				.get(String.class);

		assertEquals(Pokr.VERSION, responseMsg);
	}
}
