package com.test.teliatest.dto;
import com.test.teliatest.model.EstonianWord;
import lombok.Data;

import java.util.Set;

@Data
public class EnglishWordDto {
    private String word;
    private Set<EstonianWord> estMeaning;
}
