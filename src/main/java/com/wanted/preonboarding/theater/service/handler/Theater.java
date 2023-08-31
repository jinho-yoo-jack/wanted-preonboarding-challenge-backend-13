package com.wanted.preonboarding.theater.service.handler;

import com.wanted.preonboarding.theater.dto.request.EnterTheaterRequest;
import com.wanted.preonboarding.theater.service.handler.consumer.Consumer;
import com.wanted.preonboarding.theater.service.handler.seller.Seller;

public interface Theater {
    void enter(Consumer consumer, Seller seller);

}
