package com.wanted.preonboarding.cafe.controller;

import com.wanted.preonboarding.cafe.service.CafeService;
import com.wanted.preonboarding.cafe.service.handler.Orders;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/cafe")
@RequiredArgsConstructor
public class CafeController {

    private final CafeService cafeService;

    @GetMapping("/hello")
    public ResponseEntity<String> welcomeMessage(){
        log.info("CafeController.welcomeMessage");

        final String response = "Welcome to The Wanted coding cafe!!";
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/order")
    public ResponseEntity<String> orderFromMenu(@RequestBody Orders orders) {
        log.info("CafeController.orderFromMenu: {}", orders);

        final String response = cafeService.orderFrom(orders);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
