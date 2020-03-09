package com.mitchharris.wordcounter;

import org.testcontainers.containers.PostgreSQLContainer;

public class PostgresContainerSingleton {

    private static PostgresContainerSingleton instance = null;

    private final PostgreSQLContainer postgreSQLContainer = (PostgreSQLContainer) new PostgreSQLContainer("postgres")
            .withDatabaseName("testDB")
            .withUsername("testUser")
            .withPassword("testPassword");

    public void startContainer(){
        postgreSQLContainer.start();
    }

    public static PostgresContainerSingleton getInstance(){
        if (instance == null) {
            instance = new PostgresContainerSingleton();
        }
        return instance;
    }

    PostgreSQLContainer getPostgreSQLContainer() {
        return postgreSQLContainer;
    }
}
