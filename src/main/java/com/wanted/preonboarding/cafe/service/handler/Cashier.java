package com.wanted.preonboarding.cafe.service.handler;

import com.wanted.preonboarding.cafe.MENU;
import com.wanted.preonboarding.cafe.OrderDto;
import org.aspectj.weaver.ast.Or;

import java.util.List;
import java.util.Map;

public class Cashier {

    public long calculateTotalPrice(List<Order> orders) {
        long totalPrice = 0L;

        for (Order order : orders) {
            int cnt = order.getCount();
            int price = order.getMenu().getPrice();
            totalPrice += (long) cnt * price;
        }
        return totalPrice;
    }

    private String sendTo(Barista barista, List<Order> receivedOrders) {
        return barista.makeCoffeeTo(receivedOrders);
    }

    public String takeOrder(List<Order> receivedOrders, int baristaRank) {
        return sendTo(new Barista(baristaRank,0), receivedOrders);
    }
}
