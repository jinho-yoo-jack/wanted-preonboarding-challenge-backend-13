package com.wanted.preonboarding.cafe.domain;

public enum Status {
    WAITING,
    MAKING;

    public boolean isMaking() {
        return this.equals(MAKING);
    }
}
