package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.exception.NotAllowedAudienceException;
import com.wanted.preonboarding.theater.entity.Audience;
import com.wanted.preonboarding.theater.entity.Ticket;
import com.wanted.preonboarding.theater.entity.TicketOffice;
import com.wanted.preonboarding.theater.entity.TicketSeller;
import com.wanted.preonboarding.theater.service.handler.*;
import org.springframework.stereotype.Service;


@Service
public class TheaterService{

    private final long ticketAmount = 20000L;
    private final long ticketFee = 100L;

    public String enter(Audience audience, Theater theater) throws NotAllowedAudienceException {

        theater.enter(audience,
                    new TicketSeller(new TicketOffice(ticketAmount, new Ticket(ticketFee))));

        logOfResult(audience,theater);

        return "Have a good time.";
    }

    // DELETE AFTER VERIFICATION IN "POSTMAN"
    public void logOfResult(Audience audience,Theater theater){
        if(theater.getClass().equals(InvitedTheaterImpl.class)){
            System.out.println("theater type : " + theater.getClass());
            System.out.println("when : " + audience.getBag().getInvitation().getWhen());
            System.out.println("fee : " + audience.getBag().getTicket().getFee());
            System.out.println("amount : " + audience.getBag().getAmount());
        }else if(theater.getClass().equals(TicketTheaterImpl.class)){
            System.out.println("theater type : " + theater.getClass());
            System.out.println("fee : " + audience.getBag().getTicket().getFee());
            System.out.println("amount : " + audience.getBag().getAmount());
        }
    }
}
