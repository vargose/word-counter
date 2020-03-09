package com.mitchharris.wordcounter.serviceTest;

import com.mitchharris.wordcounter.serviceTest.dto.TestMessage;
import com.mitchharris.wordcounter.serviceTest.dto.TestMessageWordCount;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageCountTest {

    @Test
    public void Message_Returns_Word_Count() {

        Response response = given().
                when().
                contentType(ContentType.JSON).
                body(new TestMessage(UUID.randomUUID().toString(),"Hello London")).
                post("http://localhost:8080/message");

        assertEquals(HttpStatus.SC_OK, response.getStatusCode());
        assertEquals(ContentType.JSON.toString(), response.getContentType());
        TestMessageWordCount currentWordCount = response.as(TestMessageWordCount.class);

        response = given().
                when().
                contentType(ContentType.JSON).
                body(new TestMessage(UUID.randomUUID().toString(),"Hello London And Oslo")).
                post("http://localhost:8080/message");

        assertEquals(HttpStatus.SC_OK, response.getStatusCode());
        assertEquals(ContentType.JSON.toString(), response.getContentType());
        assertEquals( new TestMessageWordCount(currentWordCount.getCount() + 4), response.as(TestMessageWordCount.class));

    }
}
