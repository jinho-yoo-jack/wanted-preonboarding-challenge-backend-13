package com.wanted.preonboarding.theater.service.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Theater {
    private final TicketSellerRepository ticketSellerRepository;

    public void enter(Audience audience){
        TicketSeller ticketSeller = ticketSellerRepository.getTicketSeller();
        // 혹은 setter로 주입 받는 방식
        // new TicketSeller(TicketOffice.builder().sales(20000L).ticketFee(100L).build());

        if(audience.getWallet().hasInvitation()){
            ticketSeller.giveTicketByInvitation(audience);
        }else {
            ticketSeller.sellTicket(audience);
        }
    }
}
