package com.wanted.preonboarding.theater.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wanted.preonboarding.theater.service.TheaterService;
import com.wanted.preonboarding.theater.service.handler.RequestMessage;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/theater")
@RequiredArgsConstructor
public class TheaterController {
    
	@Autowired
	private final TheaterService theaterService;

    @GetMapping("hello")
    public String welcomeMessage(){
        return "Welcome to The Wanted Theater";
    }

    @GetMapping("enter")
    public String enter(RequestMessage requestMessage){
    	
    	String result = theaterService.enter(requestMessage);
        return result;
    }
}
