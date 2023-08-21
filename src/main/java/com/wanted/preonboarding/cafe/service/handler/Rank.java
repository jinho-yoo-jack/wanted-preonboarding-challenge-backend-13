package com.wanted.preonboarding.cafe.service.handler;

import lombok.Getter;

@Getter
public enum Rank {

    BEGINNER(0),MIDDLE(1),MASTER(2);

    private final int value;

    Rank(int value) {
        this.value = value;
    }
}
