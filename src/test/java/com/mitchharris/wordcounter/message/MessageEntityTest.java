package com.mitchharris.wordcounter.message;

import com.mitchharris.wordcounter.message.dto.Message;
import com.mitchharris.wordcounter.message.dto.MessageWordCount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MessageEntityTest {

    @Test
    void countWordsInMessage_returns_NumberOfWordsInString() {

        MessageEntity messageEntity = new MessageEntity(new Message("123", "Hello Everybody"));

        assertEquals(2, messageEntity.getWordCount());
    }

    @Test
    void countWordsInMessage_returns_NumberOfWordsInString_differentCount() {

        MessageEntity messageEntity = new MessageEntity(new Message("123", "Hello Everybody in St. Louis"));

        assertEquals(5, messageEntity.getWordCount());
    }

    @Test
    void countWordsInMessage_returns_ZeroForNull() {

        MessageEntity messageEntity = new MessageEntity(new Message("123", null));

        assertEquals(0, messageEntity.getWordCount());
    }

    @Test
    void countWordsInMessage_returns_ZeroForBlank() {

        MessageEntity messageEntity = new MessageEntity(new Message("123", ""));

        assertEquals(0, messageEntity.getWordCount());
    }

    @Test
    void countWordsInMessage_returns_ZeroForWhiteWpace() {

        MessageEntity messageEntity = new MessageEntity(new Message("123", " "));

        assertEquals(0, messageEntity.getWordCount());
    }
}