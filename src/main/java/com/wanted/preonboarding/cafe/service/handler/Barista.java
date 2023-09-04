package com.wanted.preonboarding.cafe.service.handler;

import java.util.Map;

/*
    Barista : 주문을 받아 Coffee를 만드는 책임
 */

public class Barista {
    private int rank; // 0: Beginner 1: Middle 2: Master
    private int status; // 0: Waiting 1: Making

    public Barista(int rank, int status){
        this.rank = rank;
        this.status = status;
    }

    private void setRank(int rank){
        this.rank = rank;
    }

    private void setStatus(int status){
        this.status = status;
    }

    public String makeCoffeeTo(Order order){
        StringBuilder makeOrders = new StringBuilder();
        for(OrderItem orderItem : order.getItems()){
            makeOrders.append(orderItem.toCoffee());
        }
        return makeOrders.toString();
    }
}
