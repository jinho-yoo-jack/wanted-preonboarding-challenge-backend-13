package com.wanted.preonboarding.theater.service.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 티켓을 판매하는 사람
 */
@AllArgsConstructor
public class TicketSeller {

    /** 티켓 오피스 */
    @Getter private final TicketOffice ticketOffice;
}
