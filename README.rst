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

To tests the services by hand, use curl or any browser after Jetty has been set up correctly.

Local address to use
--------------------

The base URI of the local instance is ``/pokr``. An example query is:

        http://localhost:8080/pokr/version

Building the webapp
-------------------

To create the WAR file, use:

        mvn clean package

Online demo at Heroku
---------------------

Since this is a demo to try the Heroku PaaS, here are some of the available queries.

Get the version of the REST API:

        http://whispering-retreat-7930.herokuapp.com/pokr/version

To get a JSON formatted hint, use the following URL:

        http://whispering-retreat-7930.herokuapp.com/pokr/holdemSimple/AAAAK

Rebuilding the demo
-------------------

It is as simple as the following command:

        git push heroku master

That automatically kicks in all the required processes (updating the code, setting up Java, compiling and building the WAR with Maven, strating the webapp, etc.)

Cards database
--------------

I used a simple PoC implementation for the default approximation, which is based on resources of the *moralesce* project:

        http://code.google.com/p/moralesce/

References
----------

#. [Jersey Getting Started Guide](https://jersey.java.net/documentation/latest/getting-started.html)
#. [An example Scriptable Equity Calculator](http://pokersleuth.com/programmable-poker-calculator.shtml)
#. [Heroku Dashboard of whispering-retreat-7930](https://dashboard.heroku.com/apps/whispering-retreat-7930)
#. [Some hints on how to calculate poker odds](http://entertainment.howstuffworks.com/how-to-calculate-poker-odds1.htm)
#. [A java library for Texas hold'em simulations & experiments](http://code.google.com/p/moralesce/)
