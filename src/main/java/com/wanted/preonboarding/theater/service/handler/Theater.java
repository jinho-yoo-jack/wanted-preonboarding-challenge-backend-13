package com.wanted.preonboarding.theater.service.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Theater {
	private TicketSeller ticketSeller;
	
	public Theater(TicketSeller ticketSeller) {
		this.ticketSeller = ticketSeller;
	}
	
	public TicketSeller getTicketSeller() {
		return ticketSeller;
	}
	
    public void checkTicket(Audience audience) {
        // 티켓 확인 로직을 추가할 수 있다 
    	// 예를 들어 일련번호라던지, 만료일 확인 등등 Ticket에 여러가지를 줘서 바꿀수 있다
    }

    public void sellTicket(Audience audience) {
        ticketSeller.ticketing(audience);
    }
	
}
