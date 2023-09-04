package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.controller.RequestMessage;
import com.wanted.preonboarding.theater.service.handler.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TheaterService {
    //private final Theater theater;

//    public String enter(Audience audience, TicketSeller ticketSeller){
//        theater.enter(new Audience(new Bag(1000L)),
//                new TicketSeller(new TicketOffice(20000L, new Ticket(100L))));
//        return "Have a good time.";
//
//    }
    public boolean enter(Long amount, LocalDateTime invitationDate) {

        // 고객 정보
        Bag bag = createBag(amount, invitationDate);
        Audience audience = new Audience(bag);
        Bag audienceBag = audience.getBag();

        // 영화관 정보
        TicketSeller ticketSeller = new TicketSellerImpl(new TicketOffice(20000L, new Ticket(100L)));

        // 초대권 또는 티켓 소지 여부
        if (audienceBag.hasInvitation() || audienceBag.hasTicket()) return true;

        // 티켓 구매
        if (canBuyTicket(bag, ticketSeller)) {
            buyTicket(bag, ticketSeller);
            return true;
        }

        return false;
    }


    private static boolean canBuyTicket(Bag bag, TicketSeller ticketSeller)  {
        Long ticketFee = ticketSeller.getTicketOffice().getTicket().getFee();
        long bagAmount = bag.getAmount();

        return bagAmount >= ticketFee;
    }

    private static Bag createBag(Long amount, LocalDateTime invitationDate) {
        if (invitationDate == null) return new Bag(amount);
        else {
            Invitation invitation = new Invitation(invitationDate);
            return new Bag(invitation, amount);
        }
    }

    private void buyTicket(Bag bag, TicketSeller ticketSeller) {
        Long ticketFee = ticketSeller.getTicketOffice().getTicket().getFee();
        Ticket ticket = new Ticket(ticketFee);

        bag.minusAmount(ticketFee);
        bag.setTicket(ticket);
        ticketSeller.getTicketOffice().plusAmount(ticketFee);
    }
}
