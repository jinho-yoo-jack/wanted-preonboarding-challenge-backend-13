package com.wanted.preonboarding.cafe.dto;

public enum PaymentMethod {
    CARD("Card"), CASH("Cash");

    private  final String value;

    PaymentMethod(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
