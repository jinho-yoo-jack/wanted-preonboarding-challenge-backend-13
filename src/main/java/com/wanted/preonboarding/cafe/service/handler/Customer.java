package com.wanted.preonboarding.cafe.service.handler;

import com.wanted.preonboarding.cafe.dto.OrderRequestParam;
import com.wanted.preonboarding.cafe.enums.PaymentMethod;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Customer {
    private PaymentMethod paymentMethod;
    private final List<Order> myOrders;

    public static Customer createCustomer(PaymentMethod paymentMethod, List<Order> orders) {
        return new Customer(paymentMethod, orders);
    }

    public String buyCoffee(Cashier cashier) {
        BigInteger totalPrice = cashier.calculateTotalPrice(myOrders);
        return cashier.takeOrder(myOrders, totalPrice);
    }
}
