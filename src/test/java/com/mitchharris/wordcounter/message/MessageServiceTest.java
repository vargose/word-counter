package com.mitchharris.wordcounter.message;

import com.mitchharris.wordcounter.message.dto.Message;
import com.mitchharris.wordcounter.message.dto.MessageWordCount;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MessageServiceTest {

    @Mock
    private MessageRepository messageRepository;

    @InjectMocks
    private MessageService messageService;

    @Test
    void messageService_savesIncomingMessage_andReturnsSum() {

        Message message = new Message("123", "Hello Dublin");
        int count = 4;
        when(messageRepository.sumWordCount()).thenReturn(count);

        MessageWordCount actual = messageService.getWordCountOfAllUniqueMessagesIncluding(message);

        assertEquals(new MessageWordCount(count), actual);

        InOrder inOrder = inOrder(messageRepository);

        inOrder.verify(messageRepository).save(new MessageEntity(message));
        inOrder.verify(messageRepository).sumWordCount();

    }
}