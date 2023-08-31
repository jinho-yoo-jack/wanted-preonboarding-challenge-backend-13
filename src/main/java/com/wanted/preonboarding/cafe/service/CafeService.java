package com.wanted.preonboarding.cafe.service;

import com.wanted.preonboarding.cafe.dto.OrderDto;
import com.wanted.preonboarding.cafe.service.handler.Cafe;
import com.wanted.preonboarding.cafe.service.handler.Cashier;
import com.wanted.preonboarding.cafe.service.handler.Customer;
import com.wanted.preonboarding.cafe.service.handler.PaymentMethod;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CafeService {
    private final Cafe wantedCafe;

    public String orderFrom(OrderDto orderDto){
        Cashier cashier = new Cashier(wantedCafe);
        Customer c1 = new Customer(PaymentMethod.CASH, orderDto.getOrders(), orderDto.getCustomerBalance());
        return c1.buyCoffee(cashier);
    }
}
