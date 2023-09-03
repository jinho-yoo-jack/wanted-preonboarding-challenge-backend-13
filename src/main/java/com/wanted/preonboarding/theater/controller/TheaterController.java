package com.wanted.preonboarding.theater.controller;

import com.wanted.preonboarding.cafe.service.CafeService;
import com.wanted.preonboarding.theater.dto.AudienceRequestDto;
import com.wanted.preonboarding.theater.service.TheaterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

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
    public String enter(@RequestBody AudienceRequestDto dto){
        return theaterService.enter(dto);
    }

}
