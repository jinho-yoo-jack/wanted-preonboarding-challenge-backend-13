package com.wanted.preonboarding.cafe.service.handler;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.Map;

@Getter
@Component
public class Cafe {
    private final CafeName name;

    private Long sales;

    private Cashier cashier;

    public Cafe(CafeName name, Long sales, Cashier cashier) {
        this.name = name;
        this.sales = sales;
        this.cashier = cashier;
    }

    public String takeOrder(Customer customer, Barista barista, Map<String, Long> prices) {
        Map<String, Integer> orders = customer.orderCoffee();
        verifyOrder(orders, prices);
        Long totalPrice = totalPrice(orders, prices);
        customer.pay(totalPrice);
        plusSales(totalPrice);
        return sendTo(barista, orders);
    }

    private String sendTo(Barista barista, Map<String, Integer> receivedOrders) {
        return barista.makeCoffeeTo(receivedOrders);
    }

    private Long totalPrice(Map<String, Integer> orders, Map<String, Long> prices) {
        return cashier.calculateTotalPrice(orders, prices);
    }

    private void verifyOrder(Map<String, Integer> orders, Map<String, Long> prices) {
        orders.keySet()
            .stream()
            .filter(order -> !prices.containsKey(order))
            .findFirst()
            .ifPresent(invalidOrder -> {
                throw new IllegalArgumentException("존재하지 않는 메뉴입니다.");
            });
    }

    public String getCafeName() {
        return name.getName();
    }

    public void plusSales(Long amount) {
        this.sales += amount;
    }

    public void minusSales(Long amount) {
        this.sales -= amount;
    }
}
