package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.service.handler.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TheaterService {

    public String enter(Audience audience, TicketSeller ticketSeller){
        if (!checkInvitation(audience)) { // 초대권이 없는 경우에만 티켓 구매
            if (!checkTicket(audience)) { // 티켓을 가지고 있지 않으면
                log.info("티켓을 가지고있지 않음");
                Ticket ticket = getTicketFromSeller(ticketSeller);
                purchaseTicket(audience, ticketSeller, ticket);

                saveTicket(audience, ticket);

                if (checkTicket(audience)) log.info("관객이 티켓을 구매");
            }
        }
        log.info("극장 입장 완료");
        return "Have a good time.";
    }

    private boolean checkTicket(Audience audience) {
        return audience.getBag().hasTicket();
    }
    private boolean checkInvitation(Audience audience) {
        return audience.getBag().hasInvitation();
    }
    private void purchaseTicket(Audience audience,TicketSeller ticketSeller, Ticket ticket) {
        reduceAmountFromAudience(audience, ticket);  // 관객의 돈을 줄인다.
        addAmountForTicketSeller(ticketSeller, ticket); // 샐러의 돈을 늘린다.
    }
    private Ticket getTicketFromSeller(TicketSeller ticketSeller) {
        return ticketSeller.getTicketOffice().getTicket();
    }
    private void saveTicket(Audience audience, Ticket ticket){
        audience.getBag().setTicket(ticket);
    }
    private void reduceAmountFromAudience(Audience audience, Ticket ticket) {
        audience.getBag().minusAmount(ticket.getFee());
    }
    private void addAmountForTicketSeller(TicketSeller ticketSeller, Ticket ticket) {
        ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
    }
}
