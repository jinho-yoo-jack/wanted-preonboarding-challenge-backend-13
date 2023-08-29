package com.wanted.preonboarding.theater.service.handler;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Invitation { //초대장있으면 구매 안해도됨
    private LocalDate when;

    public Invitation(LocalDate when) {
        this.when = when;
    }
}
