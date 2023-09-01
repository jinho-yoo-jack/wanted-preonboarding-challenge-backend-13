package com.wanted.preonboarding.cafe.service.handler;

import com.wanted.preonboarding.cafe.domain.Order;
import com.wanted.preonboarding.cafe.domain.PaymentType;
import com.wanted.preonboarding.cafe.dto.OrderRequest;
import java.util.List;

public class Customer {
    private final PaymentType paymentMethod;
    private final List<Order> myOrders;

    public Customer(OrderRequest orderRequest) {
        this.paymentMethod = orderRequest.getPaymentType();
        this.myOrders = orderRequest.getOrder();
    }

    public String buyCoffee(Cashier cashier) {
        long totalPrice = cashier.calculateTotalPrice(myOrders);
        return cashier.takeOrder(myOrders, totalPrice);
    }
}
