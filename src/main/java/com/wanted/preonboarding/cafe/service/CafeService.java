package com.wanted.preonboarding.cafe.service;

import com.wanted.preonboarding.cafe.controller.OrderRequest;
import com.wanted.preonboarding.cafe.service.handler.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class CafeService {
    private final Cafe wantedCafe;


    public String order(OrderRequest request) {
        Map<String, Integer> menuList = request.getMenuList();
        PaymentMethod paymentMethod = PaymentMethod.valueOf(request.getPaymentMethod());

//      계산
        Cashier cashier = wantedCafe.getWaitingCashier();
        cashier.calculateTotalPrice(paymentMethod,menuList);

//      커피 만들기
        Barista barista = wantedCafe.getWaitingBarista();
        String result = barista.makeCoffeeTo(menuList);
        return result;
    }
}
