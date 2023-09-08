package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.AudienceMapper;
import com.wanted.preonboarding.theater.service.handler.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Transactional
@Service
public class TheaterServiceImpl implements TheaterService {

    private final Theater theater;
    private final AudienceMapper audienceMapper;

    public String enter(AudienceDto audienceDto) {
        Audience audience = audienceMapper.toEntity(audienceDto);
        return theater.enter(audience);
    }

    public String refund(AudienceDto audienceDto) {
        Audience audience = audienceMapper.toEntity(audienceDto);
        return theater.refund(audience);
    }
}
