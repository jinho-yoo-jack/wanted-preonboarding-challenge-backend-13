package com.wanted.preonboarding.cafe.service.handler;

public class PaymentFactory {
    public static Payment createPayment(String payment, long balance, DiscountPolicy discountPolicy) {
        return switch (payment.toLowerCase()) {
            case "card" -> new Card(balance, discountPolicy);
            case "cash" -> new Cash(balance, discountPolicy);
            default -> null;
        };
    }
}
