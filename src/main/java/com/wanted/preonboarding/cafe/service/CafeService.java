package com.wanted.preonboarding.cafe.service;

import com.wanted.preonboarding.cafe.dto.CustomerRequest;
import com.wanted.preonboarding.cafe.dto.CustomerRequestDto;
import com.wanted.preonboarding.cafe.entity.Order;
import com.wanted.preonboarding.cafe.service.handler.Cafe;
import com.wanted.preonboarding.cafe.service.handler.Cashier;
import com.wanted.preonboarding.cafe.service.handler.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CafeService {
    private final Cafe wantedCafe;

    public String orderFrom(CustomerRequestDto requestDto){
        List<Order> orders = getOrders(requestDto);
        Cashier cashier = new Cashier(wantedCafe);
        Customer c1 = new Customer("Card", orders);
        return c1.buyCoffee(cashier);
    }

    private List<Order> getOrders(CustomerRequestDto requestDto) {
        return requestDto.getOrders().stream()
                .map(CustomerRequest::toOrder)
                .toList();
    }
}
