package com.test.teliatest.service;

import com.test.teliatest.dto.EnglishWordDto;
import com.test.teliatest.dto.EstonianWordDto;
import com.test.teliatest.model.EnglishWord;
import com.test.teliatest.model.EstonianWord;
import com.test.teliatest.repository.EnglishWordRepository;
import com.test.teliatest.repository.EstonianWordRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstonianWordService {

    @Autowired
    private EstonianWordRepository estonianWordRepository;

    @Autowired
    private ModelMapper modelMapper;

    public void saveNewEstonianWord(EstonianWordDto estonianWordDto) {
        estonianWordRepository.save(convertToEntity(estonianWordDto));
    }

    public EstonianWord findEstonianWordById(String word) {
        return null;
    }

    public List<EstonianWord> findEstonianWordFuzzy(String word) {
        return null;
    }

    //MAPPERS
    private EstonianWord convertToEntity(EstonianWordDto estonianWordDto){
        return modelMapper.map(estonianWordDto, EstonianWord.class);
    }
}
