package com.wanted.preonboarding.cafe.service.handler;

import java.util.Map;

public class Cashier {
     // Cashier에게 cafe가 있어야 할까?
    public Cashier() {
    }

    public long calculateTotalPrice(Map<String, Integer> orders, final Cafe cafe) {
        long totalPrice = 0L;
        Map<String, Integer> menus = cafe.getMenus();

        for (String menu : orders.keySet()) {
            Integer price = menus.get(menu);
            totalPrice += (long) price * orders.get(menu);
        }
        return totalPrice;
    }

    // 캐셔객체에서 굳이 바리스타가 음료를 만드는 로직을 가지고 있어야 하는가?
//    private String sendTo(Barista barista, Map<String, Integer> receivedOrders) {
//        return barista.makeCoffeeTo(receivedOrders);
//    }

//    public void takeOrder(Map<String, Integer> receivedOrders, long totalPrice) {
//        cafe.plusSales(totalPrice);
//        //return sendTo(new Barista(0,0), receivedOrders);
//    }
}
