package com.wanted.preonboarding.cafe.service;

import com.wanted.preonboarding.cafe.service.handler.Cashier;
import com.wanted.preonboarding.cafe.service.handler.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CafeService {
    private final Cashier cashier;

    public String orderFrom(Customer customer){
        return cashier.takeOrder(customer.getMyOrders());
    }
}
