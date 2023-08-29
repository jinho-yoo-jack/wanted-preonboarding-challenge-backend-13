package com.wanted.preonboarding.cafe.controller;

import com.wanted.preonboarding.cafe.dto.OrderDto;
import com.wanted.preonboarding.cafe.dto.OrderRequestDto;
import com.wanted.preonboarding.cafe.service.CafeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
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
    public String orderFromMenu(@RequestBody OrderRequestDto orderRequestDto){
        for (OrderDto order : orderRequestDto.getOrders()) {
            log.info("order drink = {}, count = {}", order.getDrink(), order.getCount());
        }
        return cafeService.orderFrom(orderRequestDto.getOrders());
    }
}
