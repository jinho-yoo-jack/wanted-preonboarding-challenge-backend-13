package com.wanted.preonboarding.theater.service.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class Theater {

    public String enterSuccess(Audience audience) {
        return "Have a good time " + audience.getName()+ ".";
    }
}
