package com.wanted.preonboarding.theater.service.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TicketSeller {
	//근무 시간, 인적사항등이 있을수 있다
	
	@Autowired
	private final TicketOffice ticketOffice;
	
	
	public void exchangeInvitation(Audience audience) {
		Ticket ticket = ticketOffice.getTicket();
		audience.getBag().setTicket(ticket);
	}
	
    public void sellTicket(Audience audience) {
		Ticket ticket = ticketOffice.getTicket();
	    audience.getBag().minusAmount(ticket.getFee());
	    ticketOffice.plusAmount(ticket.getFee());
	    audience.getBag().setTicket(ticket);
    }

}
