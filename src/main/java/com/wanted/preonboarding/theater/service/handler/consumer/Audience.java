package com.wanted.preonboarding.theater.service.handler.consumer;

import com.wanted.preonboarding.theater.dto.request.EnterTheaterRequest;
import com.wanted.preonboarding.theater.exception.NotEnoughAmountException;
import com.wanted.preonboarding.theater.service.handler.seller.Seller;
import com.wanted.preonboarding.theater.service.handler.seller.Ticket;
import lombok.Builder;

@Builder
public class Audience implements Consumer {
    private final Bag bag;

    @Override
    public void payFee(Seller seller) {
        if (bag.getAmount() < seller.getTicketFee()) {
            throw new NotEnoughAmountException("not enough amount to buy ticket.");
        }
        bag.minusAmount(seller.getTicketFee());
    }

    @Override
    public boolean hasInvitation() {
        return bag.hasInvitation();
    }

    public static Audience of(EnterTheaterRequest enterTheaterRequest) {
        return Audience.builder()
                .bag(Bag.builder()
                        .amount(enterTheaterRequest.getAmount())
                        .invitation(enterTheaterRequest.getInvitation())
                        .build())
                .build();
    }

    @Override
    public void receiveTicket(Ticket ticket) {
        bag.setTicket(ticket);
    }
}