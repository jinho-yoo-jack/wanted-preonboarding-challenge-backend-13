package com.wanted.preonboarding.theater.service.handler;

import com.wanted.preonboarding.theater.exception.TheaterException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;


class AudienceTest {

    @Test
    @DisplayName("소지금을 꺼내면 관람객의 소지금을 반환한다.")
    public void givenAudienceWhenCallGetMoneyThenReturnAudienceMoney() throws Exception {
        // given
        long expectedMoney = 1000L;
        Audience target = new Audience("test", new Bag(null, expectedMoney));

        // when
        Long actualMoney = target.getMoney();

        // then
        assertThat(actualMoney).isEqualTo(expectedMoney);
    }

    @Test
    @DisplayName("관람객이 초대권을 가진 상태에서 초대권을 꺼내면 true 를 반환한다.")
    public void givenAudienceWithInvitationWhenCallHasInvitationThenReturnTrue() throws Exception {
        // given
        Invitation invitation = new Invitation(LocalDateTime.now(), false);
        Audience target = new Audience("test", new Bag(invitation, 1000L));

        // when & then
        assertThat(target.hasInvitation()).isTrue();
    }

    @Test
    @DisplayName("관람객이 초대권을 가지지 않은 상태에서 초대권을 꺼내면 false 를 반환한다.")
    public void givenAudienceWithoutInvitationWhenCallHasInvitationThenReturnFalse() throws Exception {
        // given
        Audience target = new Audience("test", new Bag(null, 0L));

        // when & then
        assertThat(target.hasInvitation()).isFalse();
    }

    @Test
    @DisplayName("관람객이 초대권을 꺼내면 가지고 있던 초대권을 반환한다.")
    public void givenAudienceWithInvitationWhenCallGetInvitationThenReturnInvitation() throws Exception {
        // given
        Invitation invitation = new Invitation(LocalDateTime.now(), false);
        Audience target = new Audience("test", new Bag(invitation, 0L));

        // when & then
        assertThat(target.getInvitation()).isEqualTo(invitation);
    }

    @Test
    @DisplayName("관람객이 초대권이 없는데 초대권 꺼내면 에러를 반환한다.")
    public void givenAudienceWithoutInvitationWhenCallGetInvitationThenReturnTheaterException() throws Exception {
        // given
        Audience target = new Audience("test", new Bag(null, 0L));

        // when & then
        assertThatThrownBy(target::getInvitation).isExactlyInstanceOf(TheaterException.class);
    }

    @Test
    @DisplayName("티켓을 가진 관람객이 티켓 여부를 확인하면 정상 작동한다.")
    public void givenAudienceWithTicketWhenCallValidHasTicketThenNotReturnException() throws Exception {
        // given
        Audience target = new Audience("test", new Bag(null, 0L));
        target.takeTicket(new Ticket(1000L));

        // when & then
        assertThatCode(target::hasTicket).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("티켓을 가지지 않은 관람객이 티켓 여부를 확인하면 에러를 반환한다.")
    public void givenAudienceWithoutTicketWhenCallHasTicketThenReturnException() throws Exception {
        // given
        Audience target = new Audience("test", new Bag(null, 0L));

        // when & then
        assertThatThrownBy(target::hasTicket).isExactlyInstanceOf(TheaterException.class);
    }

    @Test
    @DisplayName("티켓을 가진 관람객이 티켓을 꺼내면 가지고있던 티켓을 꺼낸다.")
    public void givenAudienceWithTicketWhenCallGetTicketThenReturnTicket() throws Exception {
        // given
        Audience target = new Audience("test", new Bag(null, 0L));
        Ticket expectedTicket = new Ticket(1000L);
        target.takeTicket(expectedTicket);

        // when & then
        assertThat(target.getTicket()).isEqualTo(expectedTicket);
    }

    @Test
    @DisplayName("티켓을 가지지 않은 관람객이 티켓을 구매하면 구매에 성공한다.")
    public void givenAudienceWithoutTicketWhenBuyTicketThenAudienceBuyTicket() throws Exception {
        // given
        Audience target = new Audience("test", new Bag(null, 1000L));
        Ticket ticket = new Ticket(1000L);

        // when
        target.buyTicket(ticket);

        // then
        assertThat( target.getMoney()).isEqualTo(0L);
        assertThatCode(target::hasTicket).doesNotThrowAnyException();
        assertThat(target.getTicket()).isEqualTo(ticket);
    }

    @Test
    @DisplayName("티켓과 소지금이 없는 관람객이 티켓을 구매하면 에러를 반환한다.")
    public void givenAudienceWithoutTicketAndMoneyWhenBuyTicketThenReturnTheaterException() throws Exception {
        // given
        Audience target = new Audience("test", new Bag(null, 0L));
        Ticket ticket = new Ticket(1000L);

        // when & then
        assertThatThrownBy(() -> target.buyTicket(ticket)).isExactlyInstanceOf(TheaterException.class);
    }

    @Test
    @DisplayName("관람객이 티켓을 가방에 넣으면 해당 티켓이 가방에 들어간다.")
    public void givenAudienceWhenCallTakeTicketThenAudienceTakeTicket() throws Exception {
        // given
        Audience target = new Audience("test", new Bag(null, 0L));
        Ticket ticket = new Ticket(1000L);

        // when
        target.takeTicket(ticket);

        // then
        assertThatCode(target::hasTicket).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("티켓을 가진 관람객이 티켓을 제거하면 해당 티켓이 제거된다.")
    public void givenAudienceWithTicketWhenCallRefundTicketThenRemoveAudienceTicket() throws Exception {
        // given
        Audience target = new Audience("test", new Bag(null, 0L));
        Ticket ticket = new Ticket(1000L);
        target.takeTicket(ticket);

        // when
        target.refundTicket();

        // then
        assertThat(target.getTicket()).isNull();
    }

    @Test
    @DisplayName("티켓을 가진 관람객이 티켓을 환불하면 티켓이 제거되고 관람객의 소지금이 티켓 가격만큼 증가한다.")
    public void givenAudienceWithTicketWhenCallRefundTicketAndTakeRefundMoneyThenAudienceRefundTicket() throws Exception {
        // given
        Audience target = new Audience("test", new Bag(null, 0L));
        Ticket ticket = new Ticket(1000L);
        target.takeTicket(ticket);

        // when
        Ticket refundTicket = target.refundTicket();
        target.takeRefundMoney(refundTicket.getFee());

        // then
        assertThat(target.getMoney()).isEqualTo(ticket.getFee());
        assertThat(target.getTicket()).isNull();
    }

}