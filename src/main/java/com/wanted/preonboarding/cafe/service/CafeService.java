package com.wanted.preonboarding.cafe.service;

import com.wanted.preonboarding.cafe.dto.OrderDto;
import com.wanted.preonboarding.cafe.service.handler.Cafe;
import com.wanted.preonboarding.cafe.service.handler.Cashier;
import com.wanted.preonboarding.cafe.service.handler.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

@Service
@RequiredArgsConstructor
public class CafeService {
    private final Cashier cashier;

    public String orderFrom(List<OrderDto> orderDtoList){
        Map<String, Integer> myOrders = orderDtoList.stream()
                .collect(toMap(orderDto -> orderDto.getDrink().toUpperCase(), OrderDto::getCount));

        Customer c1 = new Customer("Card", myOrders);
        return c1.buyCoffee(cashier);
    }
}
