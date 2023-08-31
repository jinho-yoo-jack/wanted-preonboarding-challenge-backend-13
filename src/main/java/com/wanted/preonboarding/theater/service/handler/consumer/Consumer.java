package com.wanted.preonboarding.theater.service.handler.consumer;

import com.wanted.preonboarding.theater.service.handler.seller.Seller;
import com.wanted.preonboarding.theater.service.handler.seller.Ticket;

public interface Consumer {

    void payFee(Seller seller);

    boolean hasInvitation();

    void receiveTicket(Ticket ticket);
}
