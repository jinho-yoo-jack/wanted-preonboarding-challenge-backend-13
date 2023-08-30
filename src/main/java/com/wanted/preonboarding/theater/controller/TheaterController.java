package com.wanted.preonboarding.theater.controller;

import com.wanted.preonboarding.cafe.service.CafeService;
import com.wanted.preonboarding.theater.service.TheaterService;
import com.wanted.preonboarding.theater.service.handler.Audience;
import com.wanted.preonboarding.theater.service.handler.AudienceRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@Slf4j
@RestController
@RequestMapping("/theater")
@RequiredArgsConstructor
public class TheaterController {
    private final TheaterService theaterService;

    /**
     * Wanted Theater 환영 메시지
     * @return String
     */
    @GetMapping("/hello")
    public ResponseEntity<String> welcomeMessage(){
        log.info("TheaterController.welcomeMessage");

        String response = "Welcome to The Wanted Theater";
        return ResponseEntity.ok(response);
    }

    /**
     * Wanted Theater 입장
     * @return String
     */
    @GetMapping("/enter")
    public ResponseEntity<String> enter(@RequestBody AudienceRequest audienceRequest){
        log.info("TheaterController.enter: {}", audienceRequest);

        String response = theaterService.enter(Audience.builder()
                .bag(audienceRequest.getBag())
                .build());
        return ResponseEntity.ok(response);
    }
}
