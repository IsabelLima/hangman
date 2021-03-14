package com.isabel.hangman;

import com.isabel.hangman.endpoints.GameController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class HangmanApplicationTests {

	@Autowired
	private GameController gameController;

	@Test
	void contextLoads() throws Exception{
		assertThat(gameController).isNotNull();
	}

}
