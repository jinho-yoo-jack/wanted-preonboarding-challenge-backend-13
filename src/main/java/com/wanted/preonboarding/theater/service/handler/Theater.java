//package com.wanted.preonboarding.theater.service.handler;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//
//@Component
//@RequiredArgsConstructor
//public class Theater {
//
//    public void enter(Audience audience, TicketSeller ticketSeller){
//
//        TicketOffice ticketOffice = ticketSeller.getTicketOffice();
//        Ticket ticket = ticketOffice.getTicket();
//
//        if (!hasInvitation(audience)) {
//            Long ticketFee = ticket.getFee();
//            audience.getBag().minusAmount(ticketFee);
//            ticketOffice.plusAmount(ticketFee);
//        }
//
//        audience.getBag().setTicket(ticket);
//    }
//
//    private boolean hasInvitation(Audience audience) {
//        return audience.getBag().hasInvitation();
//    }
//}
