package com.wanted.preonboarding.cafe.service.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PayType {

    CARD("카드"),
    KAKAOPAY("카카오페이");

    private String title;

}
