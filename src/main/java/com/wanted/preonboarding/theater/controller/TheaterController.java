package com.wanted.preonboarding.theater.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wanted.preonboarding.theater.dto.AudienceEnterDTO;
import com.wanted.preonboarding.theater.service.TheaterService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/theater")
@RequiredArgsConstructor
public class TheaterController {
    private final TheaterService theaterService;

    @GetMapping("hello")
    public String welcomeMessage(){
        return "Welcome to The Wanted Theater";
    }

    @PostMapping("enter")
    public String enter(@RequestBody AudienceEnterDTO enterDTO){
        return theaterService.enter(enterDTO);
    }
}
