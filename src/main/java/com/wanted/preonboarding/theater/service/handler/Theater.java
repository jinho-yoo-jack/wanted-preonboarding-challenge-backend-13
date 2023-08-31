package com.wanted.preonboarding.theater.service.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@RequiredArgsConstructor
@Slf4j
public class Theater {

    private final Long TICKET_FEE = 100L;
    private TicketSeller ticketSeller=new TicketSeller(new TicketOffice(20000L, new Ticket(TICKET_FEE)));


    /**
     * 티켓을 체크함
     * @param audience
     * @return
     */
    public boolean enter(Audience audience){
        return audience.hasTicket();
    }

    /**
     * 초대권의 날짜를 확인함
     * @param invitation 초대권
     * @return
     */
    public Ticket  checkInvitation(Invitation invitation) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime invitationDate = invitation.getWhen();
        Ticket ticket = null;
        if (now.isBefore(invitationDate)
                && now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH")).equals(invitationDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH")))) {
            ticket =ticketSeller.getTicketOffice().getTicket();
        }
        return ticket;
    }

    /**
     * 티켓의 가격을 알려줌
     * @return
     */
    public Long getTicketFee() {
        return TICKET_FEE;
    }

    /**
     * 티켓을 판매함
     * @param ticketFee 티켓 요금
     * @return
     */
    public Ticket sellTicket(Long ticketFee) {
        if (ticketFee == TICKET_FEE) {
            ticketSeller.getTicketOffice().plusAmount(ticketFee);
            return ticketSeller.getTicketOffice()
                               .getTicket();
        }
        return null;
    }
}
