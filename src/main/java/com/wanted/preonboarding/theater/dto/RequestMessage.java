package com.wanted.preonboarding.theater.dto;

import lombok.Getter;

@Getter
public class RequestMessage {
    private final long amount;
    private final long ticketOfficeAmount;
    private final long ticketFee;

    public RequestMessage(final long amount, final long ticketOfficeAmount, final long ticketFee) {
        this.amount = amount;
        this.ticketOfficeAmount = ticketOfficeAmount;
        this.ticketFee = ticketFee;
    }
}
