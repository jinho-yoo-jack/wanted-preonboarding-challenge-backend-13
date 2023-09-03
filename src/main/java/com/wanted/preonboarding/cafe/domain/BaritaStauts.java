package com.wanted.preonboarding.cafe.domain;

public enum BaritaStauts {
    WAITING(0),
    MAKING(1);
    private int status;

    BaritaStauts(int status) {
        this.status = status;
    }
}
