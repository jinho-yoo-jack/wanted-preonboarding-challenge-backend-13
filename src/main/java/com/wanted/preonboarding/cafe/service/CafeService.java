package com.wanted.preonboarding.cafe.service;

import com.wanted.preonboarding.cafe.dto.OrderRequest;
import com.wanted.preonboarding.cafe.service.handler.Cafe;
import com.wanted.preonboarding.cafe.service.handler.Cashier;
import com.wanted.preonboarding.cafe.service.handler.Customer;
import com.wanted.preonboarding.cafe.service.handler.Drink;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class CafeService {
    private final Cafe wantedCafe;

    public String order(OrderRequest.OrderRequestDto orderRequest) {
        Cashier cashier = new Cashier();
        Map<Drink, Integer> orders = Map.of(Drink.valueOf(orderRequest.getTypeOfBeverage()), orderRequest.getAmount());
        Customer customer = new Customer(orderRequest.getPaymentMethod(), orders);
        return customer.buyCoffee(wantedCafe.sellBeverage(cashier, orders));
    }
}
