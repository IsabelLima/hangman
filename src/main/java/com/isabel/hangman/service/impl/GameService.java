package com.isabel.hangman.service.impl;

import com.isabel.hangman.entity.Game;
import com.isabel.hangman.repository.GameRepository;
import com.isabel.hangman.service.interfaces.GameServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GameService implements GameServiceInterface {
    @Autowired
    private GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Game save(Game game) {
        if (game.getWord().getAlreadyGuessedWord() == null) {
            String maskedWord = new String(new char[game.getWord().getWord().length()]).replace("\0", "_");
            game.getWord().setAlreadyGuessedWord(maskedWord);
        }
        return gameRepository.save(game);
    }

    public Optional<Game> findById(Long id) {
        return gameRepository.findById(id);
    }
}
