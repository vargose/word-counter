package com.mitchharris.wordcounter.serviceTest.dto;

import java.util.Objects;
import java.util.Optional;


public class TestMessage {

    private String id;

    private String message;

    public TestMessage() {
    }

    public TestMessage(String id, String message) {
        this.id = id;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestMessage message1 = (TestMessage) o;
        return Objects.equals(id, message1.id) &&
                Objects.equals(message, message1.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, message);
    }

    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
