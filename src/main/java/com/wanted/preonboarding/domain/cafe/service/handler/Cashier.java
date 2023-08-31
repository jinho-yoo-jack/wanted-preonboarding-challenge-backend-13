package com.wanted.preonboarding.domain.cafe.service.handler;

import java.util.Map;

public class Cashier {

  private final Cafe cafe;

  public Cashier(Cafe cafe) {
    this.cafe = cafe;
  }

  public long calculateTotalPrice(Map<String, Integer> orders) {
    long totalPrice = 0L;
    long americanoPrice = 100L;
    for (String key : orders.keySet()) {
        if (key.equalsIgnoreCase("AMERICANO")) {
            totalPrice += americanoPrice * orders.get(key);
        }
    }
    return totalPrice;
  }

  private String sendTo(Barista barista, Map<String, Integer> receivedOrders) {
    return barista.makeCoffeeTo(receivedOrders);
  }

  public String takeOrder(Map<String, Integer> receivedOrders, long totalPrice) {
    cafe.plusSales(totalPrice);
    return sendTo(new Barista(0, 0), receivedOrders);
  }
}
