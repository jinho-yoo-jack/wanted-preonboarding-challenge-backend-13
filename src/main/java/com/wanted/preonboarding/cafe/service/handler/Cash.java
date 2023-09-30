package com.wanted.preonboarding.cafe.service.handler;

import com.wanted.preonboarding.cafe.exception.CafeErrorCode;
import com.wanted.preonboarding.cafe.exception.CafeException;


public class Cash implements Payment {

    private Long balance;
    private final DiscountPolicy discountPolicy;

    public Cash(Long balance, DiscountPolicy discountPolicy) {
        this.balance = balance;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Long pay(Long price) {
        Long discountedPrice = discountPolicy.discount(price);
        if (balance < discountedPrice) {
            throw new CafeException(CafeErrorCode.NOT_ENOUGH_MONEY);
        }
        balance -= discountedPrice;
        return discountedPrice;
    }
}
