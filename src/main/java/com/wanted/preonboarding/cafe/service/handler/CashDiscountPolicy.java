package com.wanted.preonboarding.cafe.service.handler;

public class CashDiscountPolicy implements DiscountPolicy {
    @Override
    public Long discount(long totalPrice) {
        System.out.println("Cash Discount 20%");
        return totalPrice / 10 * 8;
    }
}
