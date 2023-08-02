package com.wanted.preonboarding.cafe.service.handler;

import java.util.Map;

public class Customer {
    private String paymentMethod;

    public Customer(String paymentMethod){
        this.paymentMethod = paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod){
        this.paymentMethod = paymentMethod;
    }

    public void buyCoffee(Cashier cashier, Map<String, Integer> orderBook){
        // 1. 원하는 음료 주문  to Cashier
        cashier.setOrder(orderBook);
        // 2. 주문한 음료수 값 * 수량 from Cashier
        long totalPrice = cashier.calculateTotalPrice();
        // 3. 결제 수단 전달 및 결제 진행
        cashier.payment();

    }
}
