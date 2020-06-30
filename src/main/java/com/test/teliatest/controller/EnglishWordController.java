package com.test.teliatest.controller;

import com.test.teliatest.dto.EnglishWordDto;
import com.test.teliatest.service.EnglishWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EnglishWordController {

    @Autowired
    private EnglishWordService englishWordService;

    @PostMapping("/english/add")
    public void newWord (@RequestBody EnglishWordDto englishWordDto){
        System.out.println(englishWordDto);
        englishWordService.saveNewEnglishWord(englishWordDto);
    }

    @GetMapping("/english/search/{word}")
    public EnglishWordDto searchForWord(@PathVariable String word) {
        return englishWordService.findEnglishWordById(word);
    }

}
