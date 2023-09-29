package com.wanted.preonboarding.cafe.service.handler;

public class CardDiscountPolicy implements DiscountPolicy {

    @Override
    public Long discount(long totalPrice) {
        System.out.println("Card Discount 10%");
        return totalPrice / 10 * 9;
    }
}
