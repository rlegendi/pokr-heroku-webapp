package com.heroku.rlegendi.pokr.heroku;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * This class launches the web application in an embedded Jetty container. This
 * is the entry point to the application. The Java command that is used for
 * launching should fire this main method.
 * 
 * @author rlegendi
 */
public class Main {
	private static void startJettyAndJoinItsProcess() throws Exception,
			InterruptedException {
		String webPort = System.getenv("PORT");
		if (webPort == null || webPort.isEmpty()) {
			webPort = "8080";
		}

		final Server server = new Server(Integer.valueOf(webPort));
		final WebAppContext root = new WebAppContext();

		root.setContextPath("/");

		// About this property, read more here:
		// http://wiki.eclipse.org/Jetty/Reference/Jetty_Classloading
		root.setParentLoaderPriority(true);

		final String webappDirLocation = "src/main/webapp/";
		root.setDescriptor(webappDirLocation + "/WEB-INF/web.xml");
		root.setResourceBase(webappDirLocation);

		server.setHandler(root);

		server.start();
		server.join();
	}

	public static void main(final String[] args) throws Exception {
		startJettyAndJoinItsProcess();
	}
}
