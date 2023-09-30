package com.wanted.preonboarding.cafe.service.handler;


public class Customer {
    private String name;
    private Payment payment;
    private Orders myOrders;

    public Customer(String name, Payment payment, Orders orders) {
        this.name = name;
        this.payment = payment;
        this.myOrders = orders;
    }

    public String getName() {
        return this.name;
    }

    public Payment getPayment() {
        return this.payment;
    }

    public Orders submitOrders() {
        return this.myOrders;
    }

    public Long payPrice(long totalPrice) {
        return this.payment.pay(totalPrice);
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

}
