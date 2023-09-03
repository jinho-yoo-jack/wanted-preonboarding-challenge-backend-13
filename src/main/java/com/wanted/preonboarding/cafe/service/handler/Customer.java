package com.wanted.preonboarding.cafe.service.handler;

public class Customer {
    private String paymentMethod;
    private final Orders myOrders;

    public Customer(String paymentMethod, Orders orders) {
        this.paymentMethod = paymentMethod;
        this.myOrders = orders;
    }

    public String buyCoffee(Cashier cashier) {
        return cashier.takeOrder(myOrders);
    }

}
