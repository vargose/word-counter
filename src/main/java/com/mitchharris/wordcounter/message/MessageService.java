package com.mitchharris.wordcounter.message;

import com.mitchharris.wordcounter.message.dto.Message;
import com.mitchharris.wordcounter.message.dto.MessageWordCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public MessageWordCount getWordCountOfAllUniqueMessagesIncluding(Message message) {
        if(!messageRepository.existsById(message.getId())) { messageRepository.save(new MessageEntity(message)); }
        return new MessageWordCount(messageRepository.sumWordCount());
    }


}
