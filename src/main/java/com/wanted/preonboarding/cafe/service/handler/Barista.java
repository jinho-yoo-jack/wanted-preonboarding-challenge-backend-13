package com.wanted.preonboarding.cafe.service.handler;

import java.util.UUID;

public class Barista {
    private int rank; // 0: Beginner 1: Middle 2: Master
    private int status; // 0: Waiting 1: Making

    public Barista(int rank, int status) {
        this.rank = rank;
        this.status = status;
    }

    private void setRank(int rank) {
        this.rank = rank;
    }

    private void setStatus(int status) {
        this.status = status;
    }

    public String makeBeverageTo(UUID orderId, Order o) {
        o.changeOrderStatus(1);
        StringBuilder makedOrders = new StringBuilder();
        makedOrders.append("주문ID: ")
            .append(orderId.toString())
            .append("\n");
        o.getOrderDetailInfo().forEach(((beverage, quantity) -> {
            makedOrders.append(beverage.getMenuName())
                .append(":")
                .append(quantity);
        }));
        o.changeOrderStatus(2);
        return makedOrders.toString();
    }

}
