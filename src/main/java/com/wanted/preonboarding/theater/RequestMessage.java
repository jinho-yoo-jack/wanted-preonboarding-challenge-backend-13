package com.wanted.preonboarding.theater;

import com.wanted.preonboarding.theater.domain.Invitation;

public record RequestMessage(
        boolean hasTicket,
        boolean isInvitation,
        Long backInMoney
) {
}
