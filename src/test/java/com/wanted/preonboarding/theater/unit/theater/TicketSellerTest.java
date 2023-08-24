package com.wanted.preonboarding.theater.unit.theater;

import com.wanted.preonboarding.theater.audience.domain.Audience;
import com.wanted.preonboarding.theater.audience.domain.Bag;
import com.wanted.preonboarding.theater.audience.domain.Invitation;
import com.wanted.preonboarding.theater.theater.handler.TicketSeller;
import com.wanted.preonboarding.theater.ticket.service.TicketOffice;
import com.wanted.preonboarding.theater.ticket.domain.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD;

@DisplayName("TicketSeller 단위 테스트 (SpringIntegrationTest)")
@DirtiesContext(classMode = AFTER_EACH_TEST_METHOD)
@SpringBootTest
public class TicketSellerTest {

    private static final long AMOUNT = 20_000L;
    private static final Ticket ticket = new Ticket(10_000L);
    @Autowired
    private TicketOffice ticketOffice;
    private Audience audienceHaveInvitation;
    private Audience audienceHaveNotInvitation;

    @BeforeEach
    void beforeEach() {
        Invitation invitation = new Invitation(LocalDateTime.now());
        Bag bagHasInvitation = new Bag(invitation, AMOUNT);
        Bag bagHasNotInvitation = new Bag(AMOUNT);

        audienceHaveInvitation = new Audience(bagHasInvitation);
        audienceHaveNotInvitation = new Audience(bagHasNotInvitation);
    }

    @DisplayName("초대가 있는 사람의 티켓 구매")
    @Test
    public void hasInvitation() {
        TicketSeller ticketSeller = new TicketSeller(audienceHaveInvitation, ticket, ticketOffice);
        ticketSeller.sellTicket();

        assertThat(ticketOffice.getAmount()).isEqualTo(AMOUNT);
    }

    @DisplayName("초대가 없는 사람의 티켓 구매")
    @Test
    public void hasNotInvitation() {
        TicketSeller ticketSeller = new TicketSeller(audienceHaveNotInvitation, ticket, ticketOffice);
        ticketSeller.sellTicket();

        assertThat(ticketOffice.getAmount()).isEqualTo(AMOUNT + ticket.getFee());
    }


}
