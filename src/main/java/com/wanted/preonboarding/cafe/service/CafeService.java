package com.wanted.preonboarding.cafe.service;

import com.wanted.preonboarding.cafe.dto.request.OrderCustomerRequest;
import com.wanted.preonboarding.cafe.service.handler.cafe.Cafe;
import com.wanted.preonboarding.cafe.service.handler.cafe.Cashier;
import com.wanted.preonboarding.cafe.service.handler.cafe.DefaultCashier;
import com.wanted.preonboarding.cafe.service.handler.cafe.PosMachine;
import com.wanted.preonboarding.cafe.service.handler.customer.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CafeService {
    private final Cafe wantedCafe;

    public String orderFrom(OrderCustomerRequest orderRequest) {
        Cashier cashier = new DefaultCashier(new PosMachine(wantedCafe));
        return cashier.takeOrder(Customer.of(orderRequest));
    }
}
