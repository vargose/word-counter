package com.mitchharris.wordcounter;

import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.testcontainers.containers.PostgreSQLContainer;

public class PostgresTestInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        PostgresContainerSingleton postgreSQLContainer = PostgresContainerSingleton.getInstance();
        TestPropertyValues.of(
                "spring.datasource.url=" +postgreSQLContainer.getPostgreSQLContainer().getJdbcUrl(),
                "spring.datasource.username=" +postgreSQLContainer.getPostgreSQLContainer().getUsername(),
                "spring.datasource.password=" +postgreSQLContainer.getPostgreSQLContainer().getPassword(),
                "spring.jpa.show-sql=true"
        ).applyTo(applicationContext.getEnvironment());
    }

}

class PostgresContainerSingleton {

    private static PostgresContainerSingleton instance = null;

    private final PostgreSQLContainer postgreSQLContainer = (PostgreSQLContainer) new PostgreSQLContainer("postgres")
            .withDatabaseName("testDB")
            .withUsername("testUser")
            .withPassword("testPassword");

    void startContainer(){
        postgreSQLContainer.start();
    }

    static PostgresContainerSingleton getInstance(){
        if (instance == null) {
            instance = new PostgresContainerSingleton();
        }
        return instance;
    }

    PostgreSQLContainer getPostgreSQLContainer() {
        return postgreSQLContainer;
    }
}

