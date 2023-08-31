package com.wanted.preonboarding.cafe.service.handler.customer;

import com.wanted.preonboarding.cafe.dto.request.OrderCustomerRequest;
import lombok.Builder;

import java.util.List;

public class Customer {
    private PaymentMethodType paymentMethod;

    private final List<Order> myOrders;

    @Builder
    public Customer(PaymentMethodType paymentMethod, List<Order> myOrders) {
        this.paymentMethod = paymentMethod;
        this.myOrders = myOrders;
    }

    public List<Order> getMyOrders() {
        return myOrders;
    }

    public PaymentMethodType getPaymentMethod() {
        return paymentMethod;
    }

    public static Customer of(OrderCustomerRequest orderCustomerRequest) {
        return Customer.builder()
                .paymentMethod(orderCustomerRequest.getPaymentMethodType())
                .myOrders(orderCustomerRequest.getOrders())
                .build();
    }

}
