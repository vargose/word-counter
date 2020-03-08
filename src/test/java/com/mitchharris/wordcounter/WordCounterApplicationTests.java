package com.mitchharris.wordcounter;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(initializers = {PostgresTestInitializer.class})
class WordCounterApplicationTests {

    @BeforeAll
    public static void beforeTests() {
        PostgresContainerSingleton.getInstance().startContainer();
    }

	@Test
	void contextLoads() {
	}

}
