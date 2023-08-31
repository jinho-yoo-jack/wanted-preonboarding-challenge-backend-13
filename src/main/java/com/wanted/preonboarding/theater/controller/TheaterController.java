package com.wanted.preonboarding.theater.controller;

import com.wanted.preonboarding.theater.dto.RequestMessage;
import com.wanted.preonboarding.theater.service.TheaterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theater")
@RequiredArgsConstructor
public class TheaterController {
    private final TheaterService theaterService = new TheaterService();
    /**
     * [비즈니스 요구사항]
     * 소극장에 입장하는 관객의 티켓을 확인하고, 
     * 만약 티켓이 없다면 구매 후, 입장을 시키고
     * 티켓이 있다면 티켓 확인 후, 입장 시킨다.
     */
    @GetMapping("hello")
    public String welcomeMessage(){
        return "Welcome to The Wanted Theater";
    }

    @PostMapping("enter")
    public String enter(@RequestBody RequestMessage requestMessage){
    	return theaterService.enter(requestMessage);
    }
    
    
}

