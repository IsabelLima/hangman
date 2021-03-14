package com.isabel.hangman.endpoints;

import com.isabel.hangman.dto.GameDTO;
import com.isabel.hangman.dto.GuessDto;
import com.isabel.hangman.entity.Game;
import com.isabel.hangman.entity.Word;
import com.isabel.hangman.mappers.GameMapper;
import com.isabel.hangman.service.impl.GameService;
import com.isabel.hangman.service.impl.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Locale;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameService gameService;
    @Autowired
    private WordService wordService;
    @Autowired
    private GameMapper mapper;

    @PostMapping
    public GameDTO startGame() {
        Word word = wordService.getRandomWord();
        Game game = new Game();
        game.setWord(word);
        return mapper.map(gameService.save(game));
    }

    @PutMapping
    public ResponseEntity<GameDTO> guessLetter(@RequestBody GuessDto guess) {
        Game game = gameService.findById(guess.getGame().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Game not found"));
        String word = game.getWord().getWord();
        if (guess.getLetter().length() != 1) {
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST, "Guess is not a letter");
        }
        char guessLetter = guess.getLetter().toUpperCase(Locale.ROOT).charAt(0);
        if (game.getGuesses().contains(guessLetter)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Repeated guess");
        }
        if(!Character.isLetter(guessLetter)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Guess is not a letter");
        }
        char[] chars = word.toCharArray();
        StringBuilder alreadyGuessed = new StringBuilder(game.getWord().getAlreadyGuessedWord());
        for (int i =0; i < chars.length; i++) {
            if (chars[i] == guessLetter) {
                alreadyGuessed.setCharAt(i, guessLetter);
            }
        }

        game.getWord().setAlreadyGuessedWord(alreadyGuessed.toString());
        game.addGuess(guessLetter);
        return  new ResponseEntity<GameDTO>(mapper.map(gameService.save(game)), HttpStatus.OK);
    }
}
