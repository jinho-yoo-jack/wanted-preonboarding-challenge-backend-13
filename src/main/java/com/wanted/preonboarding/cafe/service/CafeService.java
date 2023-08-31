package com.wanted.preonboarding.cafe.service;

import com.wanted.preonboarding.cafe.service.handler.Cashier;
import com.wanted.preonboarding.cafe.service.handler.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class CafeService {
    private final Cashier cashier;

    /**
     * 주문을 받아서 처리하는 메소드
     * @param orders 주문
     * @param paymentMethod 결제 방법
     * @return 주문 내역
     */
    public String orderFrom(Map<String, Integer> orders, String paymentMethod) throws InterruptedException {
        Customer customer = new Customer(paymentMethod, orders);
        return cashier.takeOrder(orders, customer);
    }
}
