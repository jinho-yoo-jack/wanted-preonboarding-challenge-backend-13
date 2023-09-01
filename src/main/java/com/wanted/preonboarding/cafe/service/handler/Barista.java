package com.wanted.preonboarding.cafe.service.handler;

import java.util.Map;

public class Barista {
    private Rank rank; // 0: Beginner 1: Middle 2: Master
    private Status status; // 0: Waiting 1: Making

    public Barista(Rank rank, Status status){
        this.rank = rank;
        this.status = status;
    }

    public void updateWorkingStatus(Status status) {
        this.status = status;
    }
    public boolean isWaiting(){
        return this.status == Status.WAITING;
    }

    public String makeCoffeeTo(Map<String, Integer> orders){
        this.updateWorkingStatus(Status.WORKING);
        StringBuilder makeOrders = new StringBuilder();
        for(String coffeeName : orders.keySet()){
            int quantity = orders.get(coffeeName);
            makeOrders.append(coffeeName)
                    .append(":")
                    .append(quantity);
        }
        this.updateWorkingStatus(Status.WAITING);
        return makeOrders.toString();
    }


}
