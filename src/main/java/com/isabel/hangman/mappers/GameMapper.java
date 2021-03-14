package com.isabel.hangman.mappers;

import com.isabel.hangman.dto.GameDTO;
import com.isabel.hangman.entity.Game;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GameMapper {
    GameDTO map(Game game);
}
