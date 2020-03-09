package com.mitchharris.wordcounter.message;

import com.mitchharris.wordcounter.PostgresContainerSingleton;
import com.mitchharris.wordcounter.PostgresTestInitializer;
import com.mitchharris.wordcounter.message.dto.Message;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(initializers = {PostgresTestInitializer.class})
class MessageRepositoryTest {

    @Autowired
    private MessageRepository messageRepository;

    @BeforeAll
    public static void beforeTests() {
        PostgresContainerSingleton.getInstance().startContainer();
    }

    @Test
    public void testSave_and_findById(){
        String id = "123";
        MessageEntity messageEntity = new MessageEntity(new Message(id, "Hello World"));
        messageRepository.save(messageEntity);
        Optional<MessageEntity> foundMessageEntity = messageRepository.findById(id);

        assertEquals(Optional.of(messageEntity), foundMessageEntity);
    }

    @Test
    public void testSave_and_existsById(){
        String id = "124";
        MessageEntity messageEntity = new MessageEntity(new Message(id, "Hello World"));
        messageRepository.save(messageEntity);

        assertTrue(messageRepository.existsById(id));
    }

    @Test
    public void testSum(){
        messageRepository.deleteAll();
        MessageEntity messageEntity = new MessageEntity(new Message("124", "Hello World"));
        messageRepository.save(messageEntity);

        assertEquals(2,messageRepository.sumWordCount());

        MessageEntity messageEntity2 = new MessageEntity(new Message("125", "Hello World"));
        messageRepository.save(messageEntity2);

        assertEquals(4,messageRepository.sumWordCount());
    }

}