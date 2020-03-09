package com.mitchharris.wordcounter.message;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
import java.util.Optional;

@Entity(name = "message")
public class MessageEntity {

    @Id
    private String id;

    @Column
    private String messageText;

    @Column(nullable = false)
    private Integer wordCount;

    public MessageEntity() {
    }

    public MessageEntity(String id, String messageText, Integer wordCount) {
        this.id = id;
        this.messageText = messageText;
        this.wordCount = Optional.ofNullable(wordCount).orElse(0);
    }

    public String getId() {
        return id;
    }

    public String getMessageText() {
        return messageText;
    }

    public Integer getWordCount() {
        return wordCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageEntity that = (MessageEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(messageText, that.messageText) &&
                Objects.equals(wordCount, that.wordCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, messageText, wordCount);
    }

    @Override
    public String toString() {
        return "MessageEntity{" +
                "id='" + id + '\'' +
                ", messageText='" + messageText + '\'' +
                ", wordCount=" + wordCount +
                '}';
    }
}
