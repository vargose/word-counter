package com.mitchharris.wordcounter.message;

import com.mitchharris.wordcounter.message.dto.Message;
import com.mitchharris.wordcounter.message.dto.MessageWordCount;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MessageControllerTest {

    @Mock
    private MessageService messageService;

    @InjectMocks
    private MessageController messageController;

    @Test
    void acceptMessage_Returns_WordCount() {
        Message message = new Message("123", "Hello Everyone");
        MessageWordCount expected = new MessageWordCount(2);

        when(messageService.countWordsInMessage(message)).thenReturn(expected);

        ResponseEntity<MessageWordCount> response = messageController.acceptMessage(message);

        assertSame(expected, response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}