package com.wanted.preonboarding.theater.service.handler;

import com.wanted.preonboarding.theater.dto.request.EnterTheaterRequest;
import com.wanted.preonboarding.theater.service.handler.Theater;
import com.wanted.preonboarding.theater.service.handler.consumer.Consumer;
import com.wanted.preonboarding.theater.service.handler.seller.Seller;
import org.springframework.stereotype.Component;

@Component
public class TheaterImpl implements Theater {

    @Override
    public void enter(Consumer consumer, Seller seller) {
        if (consumer.hasInvitation()) {
            seller.giveTicket(consumer);
        } else {
            consumer.payFee(seller);
            seller.receiveFee();
            seller.giveTicket(consumer);
        }
    }
}
