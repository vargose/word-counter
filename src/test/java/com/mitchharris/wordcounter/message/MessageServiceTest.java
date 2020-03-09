package com.mitchharris.wordcounter.message;

import com.mitchharris.wordcounter.message.dto.Message;
import com.mitchharris.wordcounter.message.dto.MessageWordCount;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MessageServiceTest {

    @InjectMocks
    private MessageService messageService;

    @Test
    void countWordsInMessage_returns_NumberOfWordsInString() {

        MessageWordCount messageWordCount = messageService.countWordsInMessage(new Message("123", "Hello Everybody"));

        assertEquals(new MessageWordCount(2), messageWordCount);
    }

    @Test
    void countWordsInMessage_returns_NumberOfWordsInString_differentCount() {

        MessageWordCount messageWordCount = messageService.countWordsInMessage(new Message("123", "Hello Everybody in St. Louis"));

        assertEquals(new MessageWordCount(5), messageWordCount);
    }
}