package com.wanted.preonboarding.cafe.service.handler;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@Getter
@RequiredArgsConstructor
public class Barista {
    private Rank rank;
    private Status status;

    public Barista(Rank rank, Status status){
        this.rank = rank;
        this.status = status;
    }

    private void setRank(Rank rank){
        this.rank = rank;
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
