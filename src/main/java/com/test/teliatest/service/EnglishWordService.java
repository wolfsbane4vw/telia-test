package com.test.teliatest.service;

import com.test.teliatest.dto.EnglishWordDto;
import com.test.teliatest.model.EnglishWord;
import com.test.teliatest.repository.EnglishWordRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnglishWordService {

    @Autowired
    private EnglishWordRepository englishWordRepository;

    @Autowired EstonianWordService estonianWordService;

    @Autowired
    private ModelMapper modelMapper;

    public void saveNewEnglishWord(EnglishWordDto englishWordDto){
        /*Optional<EnglishWord> engWord = englishWordRepository.findById(englishWordDto.getWord());
        if (engWord.isPresent()){
            EnglishWord wordFromDb = engWord.get();
            Set<EstonianWord> meaningsFromRest = englishWordDto.getEstMeaning();
            Set<EstonianWord> meaningsFromDb = wordFromDb.getEstMeaning();
            if (!meaningsFromDb.containsAll(meaningsFromRest)){
                meaningsFromDb.addAll(meaningsFromRest);
                wordFromDb.getEstMeaning().addAll(meaningsFromDb);
            }
            englishWordRepository.save(wordFromDb);
        }*/
        englishWordRepository.save(convertToEntity(englishWordDto));
    }

    public EnglishWordDto findEnglishWordById (String word){
        Optional<EnglishWord> wordFromDb = englishWordRepository.findById(word);
        return wordFromDb.map(this::convertToDto).orElse(null);
    }

    public List<EnglishWordDto> findEnglishWordFuzzy (String word) {
        return null;
    }

    //MAPPERS
    private EnglishWord convertToEntity(EnglishWordDto englishWordDto){
        return modelMapper.map(englishWordDto, EnglishWord.class);
    }

    private EnglishWordDto convertToDto(EnglishWord englishWord){
        return modelMapper.map(englishWord, EnglishWordDto.class);
    }
}
