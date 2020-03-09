package com.mitchharris.wordcounter.message;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, String> {

    @Query(value = "select sum(word_count) from message", nativeQuery = true)
    Integer sumWordCount();

}
