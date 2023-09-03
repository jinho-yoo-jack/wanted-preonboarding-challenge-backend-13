package com.wanted.preonboarding.cafe.handler;

import com.wanted.preonboarding.cafe.entity.Menu;

import java.util.Map;

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

    public String makeCoffeeTo(Map<Menu, Integer> orders){
        StringBuilder makeOrders = new StringBuilder();
        for(Menu coffeeName : orders.keySet()){
            int quantity = orders.get(coffeeName);
            makeOrders.append(coffeeName.name())
                    .append(":")
                    .append(quantity)
                    .append(" ");
        }
        return makeOrders.toString();
    }


}
