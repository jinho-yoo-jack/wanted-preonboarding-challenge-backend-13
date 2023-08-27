package com.wanted.preonboarding.cafe.service.handler;

import java.util.List;

public class Barista {
    private int rank; // 0: Beginner 1: Middle 2: Master
    private int status; // 0: Waiting 1: Making

    public Barista(int rank, int status){
        this.rank = rank;
        this.status = status;
    }

    public String makeCoffeeTo(List<Order> orders){
        StringBuilder makeOrders = new StringBuilder();

        orders.stream()
                .forEach(order -> {
                    makeOrders.append(order.getMenu().toString())
                            .append(":")
                            .append(order.getQuantity());
                });

        return makeOrders.toString();
    }


}
