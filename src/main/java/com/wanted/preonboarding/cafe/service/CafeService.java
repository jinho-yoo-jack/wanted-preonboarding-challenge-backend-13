package com.wanted.preonboarding.cafe.service;

import com.wanted.preonboarding.cafe.service.handler.Cafe;
import com.wanted.preonboarding.cafe.service.handler.Cashier;
import com.wanted.preonboarding.cafe.service.handler.Customer;
import com.wanted.preonboarding.cafe.service.handler.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CafeService {

    private final Cafe wantedCafe;

    public String orderFrom(List<Order> orders){

        Cashier cashier = new Cashier(wantedCafe);

        Customer customer = new Customer("Card", orders);

        String result = customer.buyCoffee(cashier);

        log.info("cashier={}", cashier);
        log.info("customer={}", customer);

        return result;
    }
}
