package com.wanted.preonboarding.cafe.service.handler;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum PaymentMethod {
    CASH("카드 결제");

    final String description;
}
