package com.wanted.preonboarding.theater.unit.audience;

import com.wanted.preonboarding.theater.audience.domain.Audience;
import com.wanted.preonboarding.theater.audience.domain.Bag;
import com.wanted.preonboarding.theater.audience.domain.Invitation;
import com.wanted.preonboarding.theater.ticket.domain.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Audience 단위 테스트")
public class AudienceTest {
    private static final long AMOUNT = 20_000L;

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

    @DisplayName("초대 확인 테스트")
    @Test
    public void hasInvitation() {
        assertThat(audienceHaveInvitation.hasInvitation()).isEqualTo(true);
        assertThat(audienceHaveNotInvitation.hasInvitation()).isEqualTo(false);
    }

    @DisplayName("티켓 넣기 테스트")
    @Test
    public void putTicketInBag() {
        final Ticket ticket = new Ticket(500L);
        audienceHaveInvitation.putTicketInBag(ticket);

        assertThat(audienceHaveInvitation.hasTicket()).isEqualTo(true);
        assertThat(audienceHaveNotInvitation.hasTicket()).isEqualTo(false);
    }

    @DisplayName("총액 차감 테스트")
    @Test
    public void dischargeAmount() {
        final long discharge = 10_000L;
        audienceHaveInvitation.dischargeAmount(discharge);

        assertThat(audienceHaveInvitation.getAmountInBag()).isEqualTo(AMOUNT - discharge);
    }
}
