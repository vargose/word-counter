package com.mitchharris.wordcounter.serviceTest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageCountTest {

    @Test
    public void Message_Returns_Word_Count() {

        Response response = given().
                when().
                body("{\"id\":\"123\",\"message\":\"Hello Nashville\"}").
                contentType(ContentType.JSON).
                post("http://localhost:8080/message");

        assertEquals(HttpStatus.SC_OK, response.getStatusCode());
        assertEquals(ContentType.JSON.toString(), response.getContentType());
        assertEquals("{\"count\":2}", response.getBody().print());
    }
}
