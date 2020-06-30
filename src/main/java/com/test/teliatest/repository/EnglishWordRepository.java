package com.test.teliatest.repository;

import com.test.teliatest.model.EnglishWord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnglishWordRepository  extends JpaRepository<EnglishWord, String> {
}
