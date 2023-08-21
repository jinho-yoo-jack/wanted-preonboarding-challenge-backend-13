package com.wanted.preonboarding.cafe.service.handler;

public enum Status {
    WAITING(0), MAKING(1);

    private final int value;

    Status(int value) {
        this.value = value;
    }
}
