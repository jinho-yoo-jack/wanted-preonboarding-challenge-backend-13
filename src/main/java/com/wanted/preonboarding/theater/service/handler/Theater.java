package com.wanted.preonboarding.theater.service.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Theater {
	private long totalEarnings = 0; // 수입을 저장할 변수
	private long ticketFee = 100L;
	private long holdingAmount = 20000L;
	
	public void enter(Audience audience) {

		TicketSeller ticketSeller = createTicketSeller();
		Ticket ticket = ticketSeller.sellTicket(audience);
		audience.getBag().setTicket(ticket);
		System.out.println(ticketSeller.getTicketOffice().getAmount()); // 티켓 판매 금액을 수입에 추가
	}

	private TicketSeller createTicketSeller() {
		TicketOffice ticketOffice = createTicketOffice();
		return new TicketSeller(ticketOffice);
	}
	
	private TicketOffice createTicketOffice() {
		Ticket ticket = new Ticket(ticketFee);
		return new TicketOffice(holdingAmount, ticket);
	}
	
}
