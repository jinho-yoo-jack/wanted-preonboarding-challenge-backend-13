package com.wanted.preonboarding.cafe.service;

import com.wanted.preonboarding.cafe.dto.OrderDto;
import com.wanted.preonboarding.cafe.service.handler.Cafe;
import com.wanted.preonboarding.cafe.service.handler.Cashier;
import com.wanted.preonboarding.cafe.service.handler.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CafeService {
    private final Cafe wantedCafe;

    public String orderFrom(OrderDto orderDto, Map<String, Integer> myOrders){
        Cashier cashier = new Cashier(wantedCafe); // 캐셔 등장
        Customer c1 = new Customer(orderDto.getPayMethod(), myOrders); // 주문 방법 및 메뉴 선택

        long totalPrice = c1.buyCoffee(cashier); // 최종 금액
        cashier.takeOrder(totalPrice); // 주문 접수 (매출 증가)

        return wantedCafe.sendTo(myOrders); // 최종 오더
    }
}
