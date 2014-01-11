pokr-heroku-webapp
==================

Project based on the followig archetype:

mvn archetype:generate -DarchetypeArtifactId=jersey-heroku-webapp \
                -DarchetypeGroupId=org.glassfish.jersey.archetypes -DinteractiveMode=false \
                -DgroupId=com.example -DartifactId=simple-heroku-webapp -Dpackage=com.example \
                -DarchetypeVersion=2.5.1

Setting up the webservice locally
---------------------------------

The project is configured in a way it can be tested locally w/o any additional setup with an embedded Jetty servlet container. To run it, use the following command:


        mvn clean package jetty:run

Testing
-------

Running the tests for the webservices is straigthforward too:

        mvn clean test

To tests the services by hand, run the following command and use curl or any browser:

        mvn exec:java

Local address
-------------

The base URI of the local instance is `/pokr`. An example query is:

        http://localhost:8080/pokr/version

Building the webapp
-------------------

To create the WAR file, use:

        mvn clean package


Cards database
--------------

I used a simple PoC implementation for the default approximation, which is based on resources of the *moralesce* project:

http://code.google.com/p/moralesce/

