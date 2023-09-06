package com.wanted.preonboarding.cafe.service.handler;

import com.wanted.preonboarding.cafe.entity.Order;
import com.wanted.preonboarding.cafe.entity.PaymentMethod;

import java.util.List;

public class Customer {
    private PaymentMethod paymentMethod;
    private final List<Order> myOrders;

    public Customer(PaymentMethod paymentMethod, List<Order> orders) {
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
