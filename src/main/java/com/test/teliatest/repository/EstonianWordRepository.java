package com.test.teliatest.repository;

import com.test.teliatest.model.EstonianWord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstonianWordRepository extends JpaRepository<EstonianWord, String> {
}
