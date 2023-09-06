package com.wanted.preonboarding.cafe.controller;

import com.wanted.preonboarding.cafe.service.CafeService;
import com.wanted.preonboarding.cafe.service.handler.Beverage;
import com.wanted.preonboarding.cafe.service.handler.Order;
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
    public String welcomeMessage(){
        return "Welcome to The Wanted coding cafe!!";
    }

    @GetMapping("order")
    public String orderFromMenu(){
        HashMap<Beverage, Integer> menu = new HashMap<>();
        menu.put(new Beverage("Americano", 1000L), 3);
        menu.put(new Beverage("CafeLatte", 1500L), 3);
        menu.put(new Beverage("Cappuccino", 2000L), 3);
        return cafeService.orderFrom(menu);
    }
}
