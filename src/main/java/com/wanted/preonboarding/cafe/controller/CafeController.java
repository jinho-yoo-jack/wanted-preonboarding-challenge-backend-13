package com.wanted.preonboarding.cafe.controller;

import com.wanted.preonboarding.cafe.DTO.AddItemRequest;
import com.wanted.preonboarding.cafe.DTO.CreateItemRequest;
import com.wanted.preonboarding.cafe.DTO.ItemDto;
import com.wanted.preonboarding.cafe.DTO.OrderRequest;
import com.wanted.preonboarding.cafe.service.CafeService;
import com.wanted.preonboarding.cafe.service.handler.Customer;
import com.wanted.preonboarding.cafe.service.handler.Item;
import com.wanted.preonboarding.cafe.service.handler.PayType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/cafe")
@RequiredArgsConstructor
public class CafeController {
    private final CafeService cafeService;

    @GetMapping("hello")
    public String welcomeMessage() {
        return "Welcome to The Wanted coding cafe!!";
    }

    //주문
    @PostMapping("order")
    public String orderFromMenu(@RequestBody OrderRequest request) throws Exception {
        PayType paymentMethod = PayType.valueOf(request.getPaymentMethod());
        Map<String, Integer> order = request.getItems().stream().collect(Collectors.toMap(ItemDto::getName, ItemDto::getAmount));
        Customer customer = new Customer(paymentMethod, order);
        return cafeService.order(customer);
    }

    //기존 아이템 재고 추가
    @PostMapping("items/add")
    public String addStock(@RequestBody AddItemRequest request) throws Exception {
        String name = request.getName();
        Integer amount = request.getAmount();
        return cafeService.addStock(name, amount);
    }

    //신규 아이템 추가
    @PostMapping("items/new")
    public String addNewItem(@RequestBody CreateItemRequest request) throws Exception {
        Item item = Item.builder()
                .name(request.getName())
                .stock(request.getAmount())
                .price(request.getPrice()).build();

        return cafeService.addNewItem(request.getName(), item);
    }


}
