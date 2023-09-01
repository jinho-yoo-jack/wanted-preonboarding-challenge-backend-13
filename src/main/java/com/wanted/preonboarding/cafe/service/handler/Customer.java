package com.wanted.preonboarding.cafe.service.handler;

import com.wanted.preonboarding.cafe.domain.Order;
import com.wanted.preonboarding.cafe.dto.OrderRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Customer {
    private String paymentMethod;
    private final List<Order> myOrders;

    public Customer(OrderRequest orderRequest) {
        this.paymentMethod = orderRequest.getPaymentType();
        this.myOrders = orderRequest.getOrder();
    }

    private void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String buyCoffee(Cashier cashier) {
        long totalPrice = cashier.calculateTotalPrice(myOrders);
        return cashier.takeOrder(myOrders, totalPrice);
    }
}
