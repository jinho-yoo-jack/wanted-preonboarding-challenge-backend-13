package com.wanted.preonboarding.cafe.service.handler;


import com.wanted.preonboarding.cafe.exception.CafeErrorCode;
import com.wanted.preonboarding.cafe.exception.CafeException;

public class Card extends CardDiscountPolicy implements Payment {

    private long balance;

    public Card(long balance) {
        this.balance = balance;
    }

    @Override
    public void pay(Long price) {
        if (balance < price) {
            throw new CafeException(CafeErrorCode.NOT_ENOUGH_MONEY);
        }
        this.balance -= price;
    }

}
