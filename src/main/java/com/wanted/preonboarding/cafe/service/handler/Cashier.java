package com.wanted.preonboarding.cafe.service.handler;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@AllArgsConstructor
public class Cashier {

    private final Cafe cafe;
    private Status status;

    private void startWork() {
        this.status = Status.WORKING;
    }

    private void finishWork() {
        this.status = Status.WAITING;
    }

    protected Status getStatus() {
        return this.status;
    }

    public String takeOrder(Customer customer) {
        startWork();
        Orders orders = customer.submitOrders();
        long totalPrice = orders.calculateTotalPrice(customer.getPayment());
        customer.payPrice(totalPrice);
        this.cafe.plusSales(totalPrice);
        Barista availableBarista = cafe.findAvailableBarista();
        finishWork();
        return availableBarista.makeCoffeeTo(orders);
    }
}
