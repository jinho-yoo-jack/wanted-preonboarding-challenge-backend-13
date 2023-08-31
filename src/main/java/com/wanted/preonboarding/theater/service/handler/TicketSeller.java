package com.wanted.preonboarding.theater.service.handler;

import lombok.*;

@Builder
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TicketSeller {
    private TicketOffice ticketOffice;
}
