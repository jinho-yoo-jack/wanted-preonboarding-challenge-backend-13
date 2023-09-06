package com.wanted.preonboarding.cafe.service.handler;

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

    public String makeCoffeeTo(Map<Beverage, Integer> orders){
        StringBuilder makeOrders = new StringBuilder();
        for(Beverage beverage : orders.keySet()){
            int quantity = orders.get(beverage);
            makeOrders.append(beverage.getName())
                .append(":")
                .append(quantity)
                .append("\n");
        }
        return makeOrders.toString();
    }


}
