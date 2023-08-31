package com.wanted.preonboarding.cafe.service.handler;

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

    public String makeCoffeeTo(Order orders){
        StringBuilder makeOrders = new StringBuilder();
        for (Order.OrderMenu orderMenu : orders.getOrderMenus()) {
            makeOrders.append(orderMenu.getMenu().name())
                .append(":")
                .append(orderMenu.getQuantity())
                .append("\n");
        }

        return makeOrders.toString();
    }


}
