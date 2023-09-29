package com.wanted.preonboarding.cafe.service.handler;

import com.wanted.preonboarding.cafe.exception.CafeErrorCode;
import com.wanted.preonboarding.cafe.exception.CafeException;


public class Cash extends CashDiscountPolicy implements Payment {

    private Long balance;

    public Cash(Long balance) {
        this.balance = balance;
    }

    @Override
    public void pay(Long price) {
        if (balance < price) {
            throw new CafeException(CafeErrorCode.NOT_ENOUGH_MONEY);
        }
        balance -= price;
    }
}
