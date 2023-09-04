package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.repository.AudienceRepository;
import com.wanted.preonboarding.theater.service.handler.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TheaterService {

    private final Theater theater;
    private final AudienceRepository audienceRepository;

    public String enter(Long id){
        Audience audience = audienceRepository.findById(id);
        theater.enter(audience);
        return "Have a good time.";
    }

}
