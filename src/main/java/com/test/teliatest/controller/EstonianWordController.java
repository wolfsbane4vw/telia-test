package com.test.teliatest.controller;

import com.test.teliatest.dto.EstonianWordDto;
import com.test.teliatest.service.EstonianWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EstonianWordController {

    @Autowired
    private EstonianWordService estonianWordService;

    @PostMapping("/estonian/add")
    public void saveNewEstonianWord (@RequestBody EstonianWordDto estonianWordDto){
        estonianWordService.saveNewEstonianWord(estonianWordDto);
    }
}
