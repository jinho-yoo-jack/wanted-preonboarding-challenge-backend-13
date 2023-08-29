package com.wanted.preonboarding.cafe.service.handler;

public class Customer {
    private String paymentMethod;
    private final OrderTable orderTable;

    public Customer(String paymentMethod, OrderTable orderTable) {
        this.paymentMethod = paymentMethod;
        this.orderTable = orderTable;
    }

    private void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String buyCoffee(Cashier cashier) {
        return cashier.takeOrder(orderTable);
    }
}
