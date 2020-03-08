# word-counter

This is a simple example application built in response to a coding challenge to demonstrate my technical ability and work processes


#### KANBAN
* As an Agile developer, I regularly use KANBAN. I built a board for this project to show how I organize my work  
* https://trello.com/b/odVC9L3R/coding-challenge

#### How to run
1. Install Docker https://www.docker.com/products/docker-desktop
2. Set environment variable to desired database password 
    * windows `set WORD_COUNTER_PASSWORD=`
    * bash `export WORD_COUNTER_PASSWORD=`
3. run the script file to start both app and database
    * windows `bin\dockerComposeUp.bat`
    * bash `chmod +x bin/dockerComposeUp.sh && ./bin/dockerComposeUp.sh`

#### End To End Testing
There are a suite of end to end test built with Rest Assured in the serviceTest module
1. Run app (see above)
2. `gradlew serviceTest --rerun-tasks --no-build-cache` 
3. results appear `serviceTest/build/reports/tests/test/index.html`
4. They are JUnit based so you can also run the from your favorite IDE