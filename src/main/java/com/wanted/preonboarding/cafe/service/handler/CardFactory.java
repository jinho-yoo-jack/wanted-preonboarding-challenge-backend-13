package com.wanted.preonboarding.cafe.service.handler;

import org.springframework.stereotype.Component;

@Component
public class CardFactory implements PaymentFactory {
    @Override
    public Payment createPayment(long balance) {
        return new Card(balance);
    }
}
