package com.wanted.preonboarding.cafe.service.handler;

import java.util.Map;

public class Customer {
    // 결제 수단
    private String paymentMethod;
    // 내가 주문한 메뉴와 수량
    private final Map<String, Integer> myOrders;

    public Customer(String paymentMethod, Map<String, Integer> orders) {
        this.paymentMethod = paymentMethod;
        this.myOrders = orders;
    }

    /**
     * 캐시어에게 주문을 하고, 주문한 음료를 받는다.
     * 캐시어가 계산하는 걸 고객이 알야야 하나?
     */
    public Map<String, Integer> orderCoffee() {
        return myOrders;
    }

    public void pay(Long totalPrice) {
        System.out.println("결제금액: " + totalPrice);
    }
}
