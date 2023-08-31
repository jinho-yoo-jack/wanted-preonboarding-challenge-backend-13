package com.wanted.preonboarding.cafe.service.handler.cafe.barista;

import com.wanted.preonboarding.cafe.service.handler.customer.Order;

import java.util.List;

public class DefaultBarista implements Barista{
    private Rank rank;
    private Status status;

    public DefaultBarista(Rank rank, Status status){
        this.rank = rank;
        this.status = status;
    }

    private void setRank(Rank rank){
        this.rank = rank;
    }

    private void setStatus(Status status){
        this.status = status;
    }

    @Override
    public String makeCoffeeTo(List<Order> receivedOrders) {
        setStatus(Status.MAKING);

        StringBuilder makeOrders = new StringBuilder();
        for (Order order : receivedOrders) {
            makeOrders.append(order.getSelectedMenu().name())
                    .append(":")
                    .append(order.getQuantity())
                    .append("\n");
        }

        setStatus(Status.WAITING);
        return makeOrders.toString();
    }


}
