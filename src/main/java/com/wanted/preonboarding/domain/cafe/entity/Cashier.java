package com.wanted.preonboarding.domain.cafe.entity;

import java.util.Map;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Cashier {

  private final Cafe cafe;
  private final Map<String, Integer> menu;
  private final Map<String, Long> CoffeePrices;

  public long calculateTotalPrice(Map<String, Integer> orders) {
    long totalPrice = 0L;

    for (String key : orders.keySet()) {
      if (menu.getOrDefault(key, 0) >= orders.get(key)) {
        totalPrice += CoffeePrices.getOrDefault(key, 0L) * orders.get(key);
      }
    }
    return totalPrice;
  }

  private String sendTo(Barista barista, Map<String, Integer> receivedOrders) {
    return barista.makeCoffeeTo(receivedOrders, cafe);
  }

  public String takeOrder(Map<String, Integer> receivedOrders, long totalPrice) {
    cafe.plusSales(totalPrice);
    return sendTo(new Barista(0, 0), receivedOrders);
  }
}
