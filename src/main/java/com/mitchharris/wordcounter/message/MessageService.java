package com.mitchharris.wordcounter.message;

import com.mitchharris.wordcounter.message.dto.Message;
import com.mitchharris.wordcounter.message.dto.MessageWordCount;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private static final String WHITE_SPACE_REGEX = "\\s+";

    public MessageWordCount countWordsInMessage(Message message) {
        return new MessageWordCount(message.getMessage().trim().split(WHITE_SPACE_REGEX).length);
    }

}
