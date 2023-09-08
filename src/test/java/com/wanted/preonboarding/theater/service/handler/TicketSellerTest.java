package com.wanted.preonboarding.theater.service.handler;

import com.wanted.preonboarding.cafe.service.handler.Status;
import com.wanted.preonboarding.theater.exception.TheaterException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class TicketSellerTest {

    @Test
    @DisplayName("판매원이 티켓을 팔면 관람객이 돈을 내고 티켓을 산다.")
    void givenAudienceWithMoneyWhenCallSellTicketToThenAudiencePayFeeAndTakeTicket() {
        TicketSeller ticketSeller = new TicketSeller(Status.WAITING);
        TicketOffice ticketOffice = new TicketOffice(List.of(ticketSeller), new ArrayList<>());
        Audience audience = new Audience("test", new Bag(new Invitation(LocalDateTime.now().plusDays(1), false), 1000L));
        Ticket ticket = new Ticket(1000L);
        ticketOffice.sellTicketTo(audience);
        assertThatCode(audience::hasTicket).doesNotThrowAnyException();
        assertThat(audience.getMoney()).isEqualTo(0L);
        assertThat(audience.getTicket()).isEqualTo(ticket);
    }

    @Test
    @DisplayName("관람객이 환불 요청을 하면 티켓을 반납하고 돈을 돌려받는다.")
    void givenAudienceWithTicketWhenCallRefundTicketToThenAudienceRemoveTicketAndPayBackFee() {
        TicketSeller ticketSeller = new TicketSeller(Status.WAITING);
        TicketOffice ticketOffice = new TicketOffice(List.of(ticketSeller), new ArrayList<>());
        Audience audience = new Audience("test", new Bag(new Invitation(LocalDateTime.now().plusDays(1), false), 0L));
        Ticket ticket = new Ticket(1000L);
        audience.takeTicket(ticket);
        ticketOffice.refundTicketTo(audience);
        assertThatThrownBy(audience::hasTicket).isExactlyInstanceOf(TheaterException.class);
        assertThat(audience.getMoney()).isEqualTo(ticket.getFee());
        assertThat(audience.getTicket()).isNull();
    }
}