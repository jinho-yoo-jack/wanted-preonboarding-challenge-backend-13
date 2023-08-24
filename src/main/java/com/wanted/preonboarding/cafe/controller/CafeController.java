package com.wanted.preonboarding.cafe.controller;

import com.wanted.preonboarding.cafe.service.CafeService;
import com.wanted.preonboarding.cafe.service.Menu;
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
    public String welcomeMessage() {
        return "Welcome to The Wanted coding cafe!!";
    }

    @PostMapping("order")
    public String orderFromMenu(@RequestBody Map<String, Integer> order) {
        return cafeService.orderFrom(changeFormat(order));
    }

    private Map<Menu, Integer> changeFormat(Map<String, Integer> order) {
        HashMap<Menu, Integer> changedOrder = new HashMap<>();
        for (String name : order.keySet()) {
            try {
                Menu menu = Menu.valueOf(name.toUpperCase());
                changedOrder.put(menu, order.get(name));
            } catch (IllegalArgumentException ignored) {
            }
        }
        return changedOrder;
    }
}
