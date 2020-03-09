package com.mitchharris.wordcounter.message;

import com.mitchharris.wordcounter.message.dto.Message;
import com.mitchharris.wordcounter.message.dto.MessageWordCount;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class MessageService {

    private static final String WHITE_SPACE_REGEX = "\\s+";

    public MessageWordCount countWordsInMessage(Message message) {
        return new MessageWordCount(getWordCount(message));
    }

    private Integer getWordCount(Message message) {
        return message.getMessage().
                map((messageText) ->
                        Arrays.stream(
                                messageText.trim().split(WHITE_SPACE_REGEX)).
                                filter( (word) -> !word.isBlank() ).toArray().length).
                orElse(0);
    }

}
