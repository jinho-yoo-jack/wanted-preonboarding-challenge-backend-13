package com.wanted.preonboarding.cafe.service;

import com.wanted.preonboarding.cafe.dto.OrderRequest;
import com.wanted.preonboarding.cafe.service.handler.Cafe;
import com.wanted.preonboarding.cafe.service.handler.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CafeService {
    private final Cafe wantedCafe;

    public String orderFrom(List<OrderRequest> orders) {
        Map<String, Integer> myOrders = new HashMap<>();
        for (OrderRequest order : orders) {
            myOrders.put(order.getName(), order.getAmount());
        }
        Customer customer = new Customer("Card", myOrders);
        return customer.buyCoffee(wantedCafe);
    }
}
