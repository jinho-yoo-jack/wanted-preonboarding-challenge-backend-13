package com.wanted.preonboarding.cafe.service.handler;

import java.util.List;
import java.util.Map;

public class Barista {
    private final Rank rank;
    private Status status;
    private final CoffeeMaker coffeeMaker;

    private void setStatus(Status status) {
        this.status = status;
    }

    public Barista(Rank rank, Status status){
        this.rank = rank;
        this.status = status;
        this.coffeeMaker = CoffeeMakerFactory.create(rank, status);
    }

    public String makeCoffee(Order order){
        setStatus(Status.MAKING);
        MadeCoffeeMap madeCoffeeMap = coffeeMaker.makeCoffee(order);
        return getString(madeCoffeeMap.getMadeCoffees());
    }

    private static String getString(Map<MenuItem, List<Coffee>> madeCoffees) {
        StringBuilder makeOrders = new StringBuilder();
        for (MenuItem menuItem : madeCoffees.keySet()) {
            int quantity = madeCoffees.get(menuItem).size();
            makeOrders.append(menuItem.getName())
                    .append(":")
                    .append(quantity)
                    .append("\n");
        }
        return makeOrders.toString();
    }

    public enum Rank {
        BEGINNER, MIDDLE, MASTER;
    }

    public enum Status {
        WAITING, MAKING
    }


}
