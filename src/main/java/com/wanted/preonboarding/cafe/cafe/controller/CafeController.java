package com.wanted.preonboarding.cafe.cafe.controller;

import com.wanted.preonboarding.cafe.cafe.service.CafeService;
import com.wanted.preonboarding.cafe.cafe.service.dto.OrderRequest;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/cafe")
@RequiredArgsConstructor
public class CafeController {
    private final CafeService cafeService;

    @GetMapping("/hello")
    public String welcomeMessage(){
        return "Welcome to The Wanted coding cafe!!";
    }

    @GetMapping("/order")
    public String orderFromMenu(){
        HashMap<String, Integer> menu = new HashMap<String, Integer>();
        menu.put("AMERICANO", 3);
        return cafeService.orderFrom(menu);
    }

    @PostMapping("/order")
    public String orderFromMenu(@RequestBody OrderRequest request) {
        cafeService.orderFrom(request);
        return "OK";
    }
}
