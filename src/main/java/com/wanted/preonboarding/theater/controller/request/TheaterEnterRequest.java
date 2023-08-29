package com.wanted.preonboarding.theater.controller.request;

public class TheaterEnterRequest {
    private boolean hasInvitation;
    private long amount;

    public TheaterEnterRequest() {
    }

    public TheaterEnterRequest(boolean hasInvitation, long amount) {
        this.hasInvitation = hasInvitation;
        this.amount = amount;
    }

    public boolean hasInvitation() {
        return hasInvitation;
    }

    public long getAmount() {
        return amount;
    }
}
