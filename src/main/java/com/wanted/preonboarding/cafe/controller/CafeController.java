package com.wanted.preonboarding.cafe.controller;

import com.wanted.preonboarding.cafe.service.CafeService;
import com.wanted.preonboarding.cafe.service.handler.Coffee;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/cafe")
@RequiredArgsConstructor
public class CafeController {
    private final CafeService cafeService;

    @GetMapping("hello")
    public String welcomeMessage() {
        return "Welcome to The Wanted coding cafe!!";
    }

    @GetMapping("order")
    public String orderFromMenu(@RequestBody Coffee coffee) {
        // HashMap<String, Integer> menu = new HashMap<String, Integer>();
        // menu.put("AMERICANO", 3);
        return cafeService.orderFrom(coffee);
    }
}
