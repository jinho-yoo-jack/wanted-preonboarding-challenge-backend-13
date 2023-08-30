package com.wanted.preonboarding.cafe.controller;

import com.wanted.preonboarding.cafe.service.CafeService;
import com.wanted.preonboarding.theater.service.handler.Order;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

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
    public String orderFromMenu(@RequestBody Order order){
        HashMap<String, Integer> menu = order.getOrder();
        return cafeService.orderFrom(menu);
    }


    /**
     * Test with
     * curl -X POST -H "Content-Type: application/json" -d '{
     *     "beverages": ["AMERICANO", "LATTE", "애지꾸 signature"],
     *     "cups": [2, 1, 3]
     * }' http://localhost:8080/cafe/order
     */

}
