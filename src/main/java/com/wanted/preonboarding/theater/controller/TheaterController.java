package com.wanted.preonboarding.theater.controller;

import com.wanted.preonboarding.theater.controller.dto.AudienceRequest;
import com.wanted.preonboarding.theater.service.TheaterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/theater")
@RequiredArgsConstructor
@Log4j2
public class TheaterController {
    private final TheaterService theaterService;

    @GetMapping("hello")
    public String welcomeMessage(){
        return "Welcome to The Wanted Theater";
    }

    @PostMapping("/enter")
    public String enter(
            @RequestBody AudienceRequest request
    ){
        log.info(request.toString());
        return theaterService.enter(request);
    }
}
