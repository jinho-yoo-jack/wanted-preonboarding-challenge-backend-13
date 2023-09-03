package com.wanted.preonboarding.cafe.service.handler;

import com.wanted.preonboarding.cafe.service.dto.CustomerDto;

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

    public String buyCoffee(Cashier cashier) {
        long totalPrice = cashier.calculateTotalPrice(myOrders);
        return cashier.takeOrder(myOrders, totalPrice);
    }

    public static Customer from(CustomerDto customerDto){
        return new Customer(customerDto.getPaymentMethod(),customerDto.getOrder());
    }
}
