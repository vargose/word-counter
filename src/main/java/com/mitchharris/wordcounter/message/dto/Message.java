package com.mitchharris.wordcounter.message.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import java.util.Objects;
import java.util.Optional;

public class Message {

    @ApiModelProperty(value = "The id of the message", required = true, example = "123")
    @NotBlank(message = "Message id cannot be blank")
    @Length(max = 255, message = "Message id is too long")
    private final String id;

    @ApiModelProperty(value = "The text of the message", example = "Hello World Text")
    @Length(max = 255, message = "Message is too long")
    private final String message;

    public Message(String id, String message) {
        this.id = id;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public Optional<String> getMessage() {
        return Optional.ofNullable(message);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message1 = (Message) o;
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
