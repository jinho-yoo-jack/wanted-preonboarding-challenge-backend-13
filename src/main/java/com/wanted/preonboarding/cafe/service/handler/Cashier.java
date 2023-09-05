package com.wanted.preonboarding.cafe.service.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class Cashier {

    private Status status;

    private void startWork() {
        this.status = Status.WORKING;
    }

    private void finishWork() {
        this.status = Status.WAITING;
    }

    public void takeOrder(Cafe cafe, Orders orders) {
        startWork();
        long totalPrice = orders.calculateTotalPrice();
        cafe.plusSales(totalPrice);
        finishWork();
    }

}
