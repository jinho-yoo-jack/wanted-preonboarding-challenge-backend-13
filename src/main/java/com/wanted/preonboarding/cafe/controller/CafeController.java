package com.wanted.preonboarding.cafe.controller;

import com.wanted.preonboarding.cafe.dto.BeverageOrder;
import com.wanted.preonboarding.cafe.service.CafeService;
import com.wanted.preonboarding.cafe.service.handler.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public String orderFromMenu(@RequestBody BeverageOrder request){

        List<Order> orders = request.getOrders().stream()
                .map(Order::ofRequest)
                .toList();

        return cafeService.orderFrom(orders);
    }
}
