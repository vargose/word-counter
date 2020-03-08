# word-counter

This is a simple example application built in response to a coding challenge to demonstrate my technical ability and work processes


####KANBAN
* As an Agile developer, I regularly use KANBAN. I built a board for this project to show how I organize my work  
* https://trello.com/b/odVC9L3R/coding-challenge

####How to run
1. Install Docker https://www.docker.com/products/docker-desktop
2. Set environment variable to desired database password 
    * windows `set WORD_COUNTER_PASSWORD=`
    * bash `export WORD_COUNTER_PASSWORD=`
3. run the script file to start both app and database
    * windows `bin\dockerComposeUp.bat`
    * bash `chmod +x bin/dockerComposeUp.sh && ./bin/dockerComposeUp.sh`
