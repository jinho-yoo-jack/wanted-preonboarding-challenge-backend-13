package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.dto.request.RequestMessage;
import com.wanted.preonboarding.theater.exception.NotEnoughAmountException;

public interface TheaterService {
    String enter(RequestMessage requestMessage) throws NotEnoughAmountException;
}
