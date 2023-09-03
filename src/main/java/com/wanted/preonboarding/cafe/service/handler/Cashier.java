package com.wanted.preonboarding.cafe.service.handler;

import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class Cashier {
    private Status status;
    private Cafe cafe;

    public boolean isWaiting() {
        return status.equals(Status.WAITING);
    }

    public void updateWorkingStatus(Status status) {
        this.status = status;
    }

    public long calculateTotalPrice(PaymentMethod method, Map<String, Integer> orders) {
        this.updateWorkingStatus(Status.WORKING);
        long totalPrice = 0L;
        for (String key : orders.keySet()) {
            Menu menu = Menu.valueOf(key);
            Integer cost = menu.getCost();
            Integer count = orders.get(key).intValue();
            totalPrice += cost * count;
        }
        this.cafe.plusSales(new Order(method, totalPrice));
        this.updateWorkingStatus(Status.WAITING);
        return totalPrice;
    }

    private String sendTo(Barista barista, Map<String, Integer> receivedOrders) {
        return barista.makeCoffeeTo(receivedOrders);
    }

}
