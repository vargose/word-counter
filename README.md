# word-counter

This is a simple example application built in response to a coding challenge to demonstrate my technical ability and work processes

#### KANBAN
* As an Agile developer, I regularly use KANBAN. I built a board for this project to show how I organize my work
* I broke the work down into 3 stories
    * An Environment Build Out
    * Counting the words in a single message
    * Returning the count of all words received thus far
* This allowed me to take an iterative and evolving approach  
* https://trello.com/b/odVC9L3R/coding-challenge

#### How to run
1. Install Docker https://www.docker.com/products/docker-desktop
2. `gradlew build`
3. Set environment variable to desired database password 
    * windows `set WORD_COUNTER_PASSWORD=`
    * bash `export WORD_COUNTER_PASSWORD=`
4. run the custom script file to start both app and database
    * windows `bin\dockerComposeUp.bat`
    * bash `chmod +x bin/dockerComposeUp.sh && ./bin/dockerComposeUp.sh`

#### End To End Testing
There are a suite of end to end test built with Rest Assured in the serviceTest module
1. Run app (see above)
2. `gradlew test -PserviceTest --rerun-tasks` 
3. results appear `serviceTest/build/reports/tests/test/index.html`
4. They are JUnit based so you can also run the from your favorite IDE

#### Features Explained
1. Using Spring Boot as the base level framework to take advantage of the MVC and ORM it provides
2. Using Spring Data Jpa to interface with the database
3. Using Docker to easily run the api and database
4. Using Spring WebMvcTest to test endpoint mappings, json serialization and deserialization, and request payload Validations
5. Using Spring DataJpaTest to test entity mappings and repository calls
6. Using Test Containers to run a real postgres docker container for DataJpaTest tests and the Application start test
7. All other functionality has been covered by Unit tests
8. Using Rest Assured for end-2-end tests
