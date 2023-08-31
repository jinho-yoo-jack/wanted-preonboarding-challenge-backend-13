package com.wanted.preonboarding.cafe.service.handler;

public class BasicCoffeeMaker implements CoffeeMaker {
    @Override
    public MadeCoffeeMap makeCoffee(Order order) {
        return order.makeCoffee();
    }
}
