gradlew dockerComposeUp -x test &&
docker logs word-counter_api_1 -f