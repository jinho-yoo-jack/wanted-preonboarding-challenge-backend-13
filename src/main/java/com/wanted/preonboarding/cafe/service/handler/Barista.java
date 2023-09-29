package com.wanted.preonboarding.cafe.service.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@RequiredArgsConstructor
@AllArgsConstructor
public class Barista {
    private final Cafe cafe;
    private Rank rank;
    private Status status;


    private void setRank(Rank rank){
        this.rank = rank;
    }

    protected Status getStatus() {
        return this.status;
    }

    public String makeCoffeeTo(Orders orders){
        startWork();
        Map<Menu, Integer> orderItems = orders.getOrderItems();
        StringBuilder makeOrders = new StringBuilder();
        for(Map.Entry<Menu, Integer> orderItem : orderItems.entrySet()){
            int quantity = orderItem.getValue();
            makeOrders.append(orderItem.getKey().getName())
                    .append(":")
                    .append(quantity)
                    .append(" ");
        }
        finishWork();
        return makeOrders.toString();
    }

    private void startWork(){
        this.status = Status.WORKING;
    }

    private void finishWork() { this.status = Status.WAITING; }

}
