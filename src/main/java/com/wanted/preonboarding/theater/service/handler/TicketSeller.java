package com.wanted.preonboarding.theater.service.handler;

public class TicketSeller {
	
    private final TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice){
        this.ticketOffice = ticketOffice;
    }

    public TicketOffice getTicketOffice(){
        return ticketOffice;
    }
    
    
    public Ticket sellTicket(Audience audience) {
    	
    	if(audience.getBag().hasInvitation()){
    		return ticketOffice.getTicket();
        }
    	else {
            Ticket ticket = ticketOffice.getTicket();
            audience.getBag().minusAmount(ticket.getFee());
            ticketOffice.plusAmount(ticket.getFee());
            return ticket;
        }
    }
    
    
}
