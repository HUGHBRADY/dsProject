## A RESTful Car Hire Booking System

This is a project for the Distributed Systems module for 4th year in GMIT. 

Task: 
You are required to use the JAX-RS/Jersey, Java RMI and JAXB frameworks to develop a simple Car Hire Booking System. A Web Client page should provide users with the ability to Create/Modify/Update/Delete bookings for a specific vehicle for a given set of dates. The Web Client will interact with a RESTful JAX-RS Web Service for bookings which is deployed on Apache Tomcat Server. The RESTful Web Service will act as a RMI client to a RMI Database Server which will handle persistence.

## WHAT YOU NEED TO RUN
Here is a list of what you need to run this project that is not included in this repository.
1. Wamp64 http://www.wampserver.com/en/download-wampserver-64bits/
2. Apache Tomcat v7.0 https://tomcat.apache.org/download-70.cgi
3. Eclipse Jee Photon https://www.eclipse.org/photon/

### HOW TO RUN
1. Clone this repository to your local machine. 
2. Open the RmiServer project in eclipse.
3. Right click on the project in the package explorer and select properties -> Java Build Path. Click on Add External Jars and select the mysql-connector jar file included in this repository. Click apply and close.
4. Open the Servers window and click on add a server and follow the instructions to add Tomcat 7 to the workspace.
5. Launch wamp and open the mySQL console. Paste the contents of dbCommands.txt (located in this repo) into the console to create the database.
6. Run the RmiServer project in Eclipse.
7. Run the WebService project in Eclipse.
