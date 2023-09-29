package com.wanted.preonboarding.cafe.service.handler;

import org.springframework.stereotype.Component;

@Component
public class CashFactory implements PaymentFactory {
    @Override
    public Payment createPayment(long balance) {
        return new Cash(balance);
    }
}
