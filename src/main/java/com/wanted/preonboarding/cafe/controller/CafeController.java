package com.wanted.preonboarding.cafe.controller;

import com.wanted.preonboarding.cafe.dto.OrderDto;
import com.wanted.preonboarding.cafe.service.CafeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/cafe")
@RequiredArgsConstructor
public class CafeController {
    private final CafeService cafeService;

    @GetMapping("hello")
    public String welcomeMessage(){
        return "Welcome to The Wanted coding cafe!!";
    }

    @PostMapping("order")
    public String orderFromMenu(@RequestBody OrderDto orderDto){
        Map<String, Integer> myOrders = new HashMap<>(); // 메뉴 고르기
        myOrders.put(orderDto.getMenu(), orderDto.getAmount());
        return cafeService.orderFrom(orderDto, myOrders);
    }
}
