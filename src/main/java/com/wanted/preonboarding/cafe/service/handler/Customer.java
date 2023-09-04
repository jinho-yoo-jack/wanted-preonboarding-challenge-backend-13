package com.wanted.preonboarding.cafe.service.handler;

import java.util.HashMap;
import java.util.Map;

public class Customer {
    private String paymentMethod;
    private final Map<String, Integer> myOrders;

    public Customer(String paymentMethod, Map<String, Integer> orders) {
        this.paymentMethod = paymentMethod;
        this.myOrders = orders;
    }

    private void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    // Customer객체에서 cashier가 계산하고 주문하는 코드가 들어가 있음.
//    public String buyCoffee(Cashier cashier) {
//        long totalPrice = cashier.calculateTotalPrice(myOrders);
//        return cashier.takeOrder(myOrders, totalPrice);
//    }

}
