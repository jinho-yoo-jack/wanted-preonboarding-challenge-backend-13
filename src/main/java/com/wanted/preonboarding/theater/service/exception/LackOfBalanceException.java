package com.wanted.preonboarding.theater.service.exception;

import lombok.Builder;

@Builder
public final class LackOfBalanceException extends RuntimeException {
    private final long requiredAmount;
    private final long currentBalance;

    public LackOfBalanceException(long requiredAmount, long currentBalance) {
        super("Insufficient balance. Required: " + requiredAmount + ", Current balance: " + currentBalance);
        this.requiredAmount = requiredAmount;
        this.currentBalance = currentBalance;
    }

    public long getRequiredAmount() {
        return requiredAmount;
    }

    public long getCurrentBalance() {
        return currentBalance;
    }
}
