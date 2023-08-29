package com.wanted.preonboarding.cafe.service.handler;

public class Customer {
    private PaymentMethod paymentMethod;
    private final CaffeOrders myCaffeOrders;

    public Customer(PaymentMethod paymentMethod, CaffeOrders caffeOrders) {
        this.paymentMethod = paymentMethod;
        this.myCaffeOrders = caffeOrders;
    }

    public String buyCoffee(Cashier cashier) {
        return cashier.takeOrder(myCaffeOrders);
    }
}
