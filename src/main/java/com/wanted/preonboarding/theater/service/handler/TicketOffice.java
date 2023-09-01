package com.wanted.preonboarding.theater.service.handler;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TicketOffice {
    private long amount;
    private final List<Ticket> tickets;
    
	public long getAmount() {
		return amount;
	}
	
	public void plusAmount(long amount) {
		this.amount += amount;
	}
	
	public void minusAmount(long amount) {
		this.amount -= amount;
	}


	public void setAmount(long amount) {
		this.amount = amount;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}
	
	public Ticket getTicket() {
		return tickets.get(0);
	}

	
}
