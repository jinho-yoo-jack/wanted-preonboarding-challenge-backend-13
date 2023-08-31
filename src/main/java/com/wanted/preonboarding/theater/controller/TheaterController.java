package com.wanted.preonboarding.theater.controller;

import com.wanted.preonboarding.cafe.service.CafeService;
import com.wanted.preonboarding.theater.service.TheaterService;
import com.wanted.preonboarding.theater.service.handler.Audience;
import com.wanted.preonboarding.theater.service.handler.AudienceInfoRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/theater")
@RequiredArgsConstructor
public class TheaterController {
    private final TheaterService theaterService;


    /** 인사 */
    @GetMapping("/hello")
    public String welcomeMessage(){
        return "Welcome to The Wanted Theater";
    }

    /**
     * 관객의 입장 조건을 확인 한 후 입장 시키는 URL
     * 입장 조건
     * 1. 티켓이 있다
     * 2. 초대권 (오늘 날짜와 시간이 맞는)이 있다.
     * 3. 티켓을 구매할 수 있는 돈이 있다.
     *
     * @param audienceInfoRequest 관객의 정보
     * @return 입장인지 불가인지
     */
    @RequestMapping("/enter")
    public ResponseEntity enter(@Valid @RequestBody AudienceInfoRequest audienceInfoRequest, BindingResult bindingResult){
        //유효성 검증
        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                System.out.println("error object name : "+ error.getObjectName());
                System.out.println("error default message : "+ error.getDefaultMessage());
                System.out.println("error arguments : " + error.getArguments());
            }
            return new ResponseEntity("Error input Data", HttpStatus.BAD_REQUEST);
        }

        String message = theaterService.enter(audienceInfoRequest.toAudience());
        return new ResponseEntity(message, HttpStatus.OK);
    }
}
