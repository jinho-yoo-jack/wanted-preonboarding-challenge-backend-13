package com.wanted.preonboarding.cafe.service;

import com.wanted.preonboarding.cafe.entity.dto.OrderRequestParam;
import com.wanted.preonboarding.cafe.service.handler.Cafe;
import com.wanted.preonboarding.cafe.service.handler.Cashier;
import com.wanted.preonboarding.cafe.service.handler.Customer;
import com.wanted.preonboarding.cafe.service.handler.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CafeService {
    private final Cafe wantedCafe;

    public String orderFrom(List<OrderRequestParam> menu){
        Cashier cashier = new Cashier(wantedCafe);
        Customer c1 = new Customer("Card", Order.createOrder(menu));
        return c1.buyCoffee(cashier);
    }
}
