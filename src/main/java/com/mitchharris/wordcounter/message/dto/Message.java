package com.mitchharris.wordcounter.message.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

public class Message {

    @ApiModelProperty(value = "The id of the message", required = true, example = "123")
    private final String id;

    @ApiModelProperty(value = "The text of the message", example = "Hello World Text")
    private final String message;

    public Message(String id, String message) {
        this.id = id;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message1 = (Message) o;
        return id.equals(message1.id) &&
                message.equals(message1.message);
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
