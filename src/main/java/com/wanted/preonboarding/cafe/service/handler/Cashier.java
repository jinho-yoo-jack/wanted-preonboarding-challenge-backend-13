package com.wanted.preonboarding.cafe.service.handler;

import java.util.Map;

public class Cashier {
    private final Cafe cafe;

    public Cashier(Cafe cafe) {
        this.cafe = cafe;
    }

    public long calculateTotalPrice(List<OrderMenu> orders) {
        long totalPrice = 0L;
        for (OrderMenu orderMenu : orders) {
            totalPrice += orderMenu.getCafeMenu().getPrice() * orderMenu.getCount();
        }
        return totalPrice;
    }

    private String sendTo(Barista barista, List<OrderMenu> receivedOrders) {
        return barista.makeCoffeeTo(receivedOrders);
    }

    public String takeOrder(List<OrderMenu> receivedOrders, long totalPrice) {
        cafe.plusSales(totalPrice);
        // Cashier가 Barista 객체를 따로 생성할 책임은 없다고 봄
        // 카페 소속의 바리스타에게 전달하도록 변경
        return sendTo(cafe.getBarista(), receivedOrders);
    }
}
