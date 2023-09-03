package com.wanted.preonboarding.cafe.handler;

import com.wanted.preonboarding.cafe.entity.Menu;
import com.wanted.preonboarding.cafe.entity.PaymentMethod;

import java.util.Map;

public class Customer {
    private PaymentMethod paymentMethod;
    private final Map<Menu, Integer> myOrders;

    public Customer(PaymentMethod paymentMethod, Map<Menu, Integer> orders) {
        this.paymentMethod = paymentMethod;
        this.myOrders = orders;
    }

    private void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String buyCoffee(Cashier cashier) {
        long totalPrice = cashier.calculateTotalPrice(myOrders);
        return cashier.takeOrder(myOrders, totalPrice);
    }
}
