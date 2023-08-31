package com.wanted.preonboarding.cafe.service.handler;

public class Customer {
    private PaymentMethod paymentMethod;
    private final Order myOrders;

    public Customer(PaymentMethod paymentMethod, Order orders) {
        this.paymentMethod = paymentMethod;
        this.myOrders = orders;
    }

    private void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String buyCoffee(Cashier cashier) {
        return cashier.takeOrder(myOrders);
    }
}
