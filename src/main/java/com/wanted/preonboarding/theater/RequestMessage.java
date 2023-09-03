package com.wanted.preonboarding.theater;

public record RequestMessage(
        boolean hasTicket,
        boolean isInvitation,
        Long backInMoney
) {
}
