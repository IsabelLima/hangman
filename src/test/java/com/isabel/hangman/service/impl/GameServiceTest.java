package com.isabel.hangman.service.impl;

import com.isabel.hangman.entity.Game;
import com.isabel.hangman.entity.Word;
import com.isabel.hangman.repository.GameRepository;
import com.isabel.hangman.repository.WordRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.*;

class GameServiceTest {

    @Mock
    GameRepository gameRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldCallRepositorySaveWhenSaveGame() {
        GameService gameService = new GameService(gameRepository);
        Game game = new Game();
        Word word = new Word();
        word.setWord("WORD");
        game.setWord(word);
        Mockito.when(gameRepository.save(game)).thenReturn(game);
        gameService.save(game);
        Mockito.verify(gameRepository).save(game);
    }

    @Test
    void shouldReturnAGameWhenSaveGame() {
        GameService gameService = new GameService(gameRepository);
        Game game = new Game();
        Word word = new Word();
        word.setWord("WORD");
        game.setWord(word);
        Mockito.when(gameRepository.save(game)).thenReturn(game);
        Game result = gameService.save(game);
        assertEquals(game, result);
    }

    @Test
    void shouldFindById() throws Exception{
        GameService gameService = new GameService(gameRepository);
        Game game = new Game();
        Word word = new Word();
        word.setWord("WORD");
        game.setWord(word);
        Mockito.when(gameRepository.findById(1l)).thenReturn(java.util.Optional.of(game));
        Game result = gameService.findById(1l)
                .orElseThrow(() -> new Exception());
        assertEquals(game, result);
    }
}