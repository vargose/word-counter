package com.mitchharris.wordcounter.message;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mitchharris.wordcounter.message.dto.Message;
import com.mitchharris.wordcounter.message.dto.MessageWordCount;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = MessageController.class)
@ExtendWith(SpringExtension.class)
class MessageControllerMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private MessageService messageService;

    @Test
    void whenValidInput_thenReturns200() throws Exception {
        Message message = new Message("123", "Hello London");

        MessageWordCount expected = new MessageWordCount(2);
        when(messageService.getWordCountOfAllUniqueMessagesIncluding(message)).thenReturn(expected);

        mockMvc.perform(post("/message")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(message)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(content().json(objectMapper.writeValueAsString(expected)));
    }

    @Test
    void whenValidInput_nullId_Returns400() throws Exception {
        Message message = new Message(null, "Hello London");

        mockMvc.perform(post("/message")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(message)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void whenValidInput_emptyId_Returns400() throws Exception {
        Message message = new Message("", "Hello London");

        mockMvc.perform(post("/message")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(message)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void whenValidInput_blankId_Returns400() throws Exception {
        Message message = new Message(" ", "Hello London");

        mockMvc.perform(post("/message")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(message)))
                .andExpect(status().isBadRequest());
    }


}