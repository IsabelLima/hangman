package com.isabel.hangman.service.impl;

import com.isabel.hangman.entity.Word;
import com.isabel.hangman.repository.WordRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WordServiceTest {

    @Mock
    WordRepository wordRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldGetRandomWord() {
        Word word = new Word();
        word.setWord("WORD");
        Word word2 = new Word();
        word.setWord("WORD2");
        List<Word> words = new ArrayList<>();
        words.add(word);
        words.add(word2);
        Mockito.when(wordRepository.findAll()).thenReturn(words);
        WordService wordService = new WordService(wordRepository);
        Word randomWord = wordService.getRandomWord();
        assertTrue(randomWord.equals(word) || randomWord.equals(word2));
    }
}