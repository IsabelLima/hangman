package com.isabel.hangman.repository;

import com.isabel.hangman.entity.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, Long> {
}
