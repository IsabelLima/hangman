package com.isabel.hangman.repository;

import com.isabel.hangman.entity.Word;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface WordRepository extends JpaRepository<Word, Long> {
}
