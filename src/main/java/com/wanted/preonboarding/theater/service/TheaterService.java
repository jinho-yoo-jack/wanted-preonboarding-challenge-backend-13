package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.service.handler.AudienceDto;

public interface TheaterService {
    String enter(AudienceDto audienceDto);

    String refund(AudienceDto audienceDto);
}
