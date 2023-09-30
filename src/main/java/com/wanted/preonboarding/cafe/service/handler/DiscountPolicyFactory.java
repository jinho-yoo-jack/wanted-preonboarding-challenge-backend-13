package com.wanted.preonboarding.cafe.service.handler;

public class DiscountPolicyFactory {
    public static DiscountPolicy createDiscountPolicyBy(String payment) {
        return switch (payment.toLowerCase()) {
            case "card" -> new CardDiscountPolicy();
            case "cash" -> new CashDiscountPolicy();
            default -> null;
        };
    }
}
