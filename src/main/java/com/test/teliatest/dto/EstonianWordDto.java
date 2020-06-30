package com.test.teliatest.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.test.teliatest.model.EnglishWord;
import lombok.Data;

import java.util.Set;

@Data
public class EstonianWordDto {
    private String word;
    private Set<EnglishWordDto> engMeaning;
}
