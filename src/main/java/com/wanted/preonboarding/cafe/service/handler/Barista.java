package com.wanted.preonboarding.cafe.service.handler;

import lombok.Getter;

import java.util.Map;

@Getter
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

    public String makeCoffeeTo(Orders orders){
        setStatus(1);
        Map<Menu, Integer> orderItems = orders.getOrderItems();
        StringBuilder makeOrders = new StringBuilder();
        for(Map.Entry<Menu, Integer> orderItem : orderItems.entrySet()){
            int quantity = orderItem.getValue();
            makeOrders.append(orderItem.getKey().getName())
                    .append(":")
                    .append(quantity)
                    .append(" ");
        }
        setStatus(0);
        return makeOrders.toString();
    }


}
