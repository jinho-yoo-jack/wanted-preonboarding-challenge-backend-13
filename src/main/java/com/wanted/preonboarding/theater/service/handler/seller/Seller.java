package com.wanted.preonboarding.theater.service.handler.seller;

import com.wanted.preonboarding.theater.service.handler.consumer.Consumer;

public interface Seller {

    void receiveFee();

    void giveTicket(Consumer consumer);

    Long getTicketFee();
}
