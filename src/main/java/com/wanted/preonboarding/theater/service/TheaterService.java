package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.service.handler.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TheaterService {
    private final Theater theater;

    public String enter(Audience audience){

        log.info("audience : {}", audience);

        // 소극장 관련 정보 입력
        Ticket ticket = new Ticket(100L);
        TicketOffice ticketOffice = new TicketOffice(20000L, ticket);
        TicketSeller ticketSeller = new TicketSeller(ticketOffice);

        Ticket getTicket = getTicket(ticketSeller);     // 티켓 가져오기
        Long ticketFee = getTicketFee(ticketSeller);    // 티켓 요금
        Long audienceAmount = audience.getAmount();     // 관람객 자금

        if(!audience.hasInvitation() && (audienceAmount - ticketFee) < 0) {
            return "초대권 혹은 티켓을 구매할 돈이 필요합니다.";
        }

        if(!audience.hasInvitation()){
            buyTicket(audience, ticketFee);
            sellTicket(ticketSeller, ticketFee);
        }

        putInTheBag(audience, getTicket);

        theater.enter(audience);

        return "Have a good time.";

    }

    private static void sellTicket(TicketSeller ticketSeller, Long ticketFee) {
        ticketSeller.getTicketOffice().plusAmount(ticketFee);
    }

    private static void buyTicket(Audience audience, Long ticketFee) {
        audience.getBag().minusAmount(ticketFee);
    }

    private static Long getTicketFee(TicketSeller ticketSeller) {
        return ticketSeller.getTicket().getFee();
    }

    private static void putInTheBag(Audience audience, Ticket ticket) {
        audience.setTicket(ticket);
    }

    private static Ticket getTicket(TicketSeller ticketSeller) {
        return ticketSeller.getTicket();
    }
}
