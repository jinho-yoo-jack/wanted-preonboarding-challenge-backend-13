package com.wanted.preonboarding.cafe.controller;

import com.wanted.preonboarding.cafe.dto.OrderDto;
import com.wanted.preonboarding.cafe.service.CafeService;
import com.wanted.preonboarding.cafe.service.handler.Order;
import com.wanted.preonboarding.cafe.service.handler.OrderItem;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

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
    public String orderFromMenu(@RequestBody OrderDto orderDto){
        List<OrderItem> orderItems = orderDto.getItems().stream()
                .map(item -> new OrderItem(item.getName(), item.getQuantity()))
                .collect(Collectors.toList());
        Order order = new Order(orderItems);
        return cafeService.orderFrom(order);
    }
}
