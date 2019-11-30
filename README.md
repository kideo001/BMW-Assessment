Basic client server system to make a call to a REST service and display data in NodeJs React type application.

Both client and server have a run.sh script, that will startup the components.

Requirements to run.

1. latest version of maven should be installed and added to the $PATH variable
2. docker should be installed.

Structure.

SERVER
SpringBoot application that exposes 1 REST Service and endpoint /data

CLIENT
React App with nginx layer for web visibility.

Things to note


Client runs on localhost:3000
Server runs on localhost:8080

The above can be changed, but take note of the cors policy in the server side REST controller as that would have to change as well.
Currectly it only allows for localhost:8080 to the client.


