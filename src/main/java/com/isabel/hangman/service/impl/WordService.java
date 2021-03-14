package com.isabel.hangman.service.impl;

import com.isabel.hangman.entity.Word;
import com.isabel.hangman.repository.WordRepository;
import com.isabel.hangman.service.interfaces.WordServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;

@Service
public class WordService implements WordServiceInterface {
    @Autowired
    private WordRepository wordRepository;

    @Override
    public Word getRandomWord() {
        List<Word> allWords = wordRepository.findAll();
        SecureRandom rand = new SecureRandom();
        Word randomWord = allWords.remove(rand.nextInt(allWords.size()));
        return randomWord;
    }
}
