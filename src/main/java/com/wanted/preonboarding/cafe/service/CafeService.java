package com.wanted.preonboarding.cafe.service;

import com.wanted.preonboarding.cafe.service.handler.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CafeService {
    private final Cafe wantedCafe;

    public String order(CaffeOrders caffeOrders, PaymentMethod paymentMethod){
        Cashier cashier = new Cashier(wantedCafe);
        Customer customer = new Customer(paymentMethod, caffeOrders);
        return customer.buyCoffee(cashier);
    }
}
