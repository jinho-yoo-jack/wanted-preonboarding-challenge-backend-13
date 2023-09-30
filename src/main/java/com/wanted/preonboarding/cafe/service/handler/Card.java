package com.wanted.preonboarding.cafe.service.handler;


import com.wanted.preonboarding.cafe.exception.CafeErrorCode;
import com.wanted.preonboarding.cafe.exception.CafeException;

public class Card implements Payment {

    private long balance;
    private final DiscountPolicy discountPolicy;

    public Card(long balance, DiscountPolicy discountPolicy) {
        this.balance = balance;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Long pay(Long price) {
        Long discountedPrice = discountPolicy.discount(price);
        if (balance < discountedPrice) {
            throw new CafeException(CafeErrorCode.NOT_ENOUGH_MONEY);
        }
        this.balance -= discountedPrice;
        return discountedPrice;
    }
}
