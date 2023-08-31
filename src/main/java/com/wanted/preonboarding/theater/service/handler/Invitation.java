package com.wanted.preonboarding.theater.service.handler;

import java.time.LocalDateTime;

public class Invitation {
    private LocalDateTime when;

    public Invitation(LocalDateTime when) {
        this.when = when;
    }

    public boolean isAfter(){
        return  when.isAfter(LocalDateTime.now());
    }
}
