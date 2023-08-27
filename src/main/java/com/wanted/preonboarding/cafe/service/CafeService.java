package com.wanted.preonboarding.cafe.service;

import com.wanted.preonboarding.cafe.dto.OrderRequestParam;
import com.wanted.preonboarding.cafe.enums.PaymentMethod;
import com.wanted.preonboarding.cafe.service.handler.Cafe;
import com.wanted.preonboarding.cafe.service.handler.Cashier;
import com.wanted.preonboarding.cafe.service.handler.Customer;
import com.wanted.preonboarding.cafe.service.handler.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.wanted.preonboarding.cafe.enums.PaymentMethod.*;
import static com.wanted.preonboarding.cafe.service.handler.Customer.*;
import static com.wanted.preonboarding.cafe.service.handler.Order.*;

@Service
@RequiredArgsConstructor
public class CafeService {
    private final Cafe wantedCafe;

    public String orderFrom(List<OrderRequestParam> menu){
        Customer customer = createCustomer(CARD, createOrderFrom(menu));

        Cashier cashier = new Cashier(wantedCafe);
        return customer.buyCoffee(cashier);
    }
}
