package com.wanted.preonboarding.cafe.service;

import static com.wanted.preonboarding.cafe.service.handler.PaymentMethod.*;

import org.springframework.stereotype.Service;

import com.wanted.preonboarding.cafe.dto.OrderDTO;
import com.wanted.preonboarding.cafe.service.handler.Cafe;
import com.wanted.preonboarding.cafe.service.handler.Cashier;
import com.wanted.preonboarding.cafe.service.handler.Customer;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CafeService {
    private final Cafe wantedCafe;

    public String orderFrom(OrderDTO orderDTO){
        Cashier cashier = new Cashier(wantedCafe);
        Customer c1 = new Customer(CARD, orderDTO.toOrder());
        return c1.buyCoffee(cashier);
    }
}
