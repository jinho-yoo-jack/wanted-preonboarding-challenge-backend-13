package com.wanted.preonboarding.theater.service.handler;

import com.wanted.preonboarding.cafe.service.handler.Status;
import com.wanted.preonboarding.theater.exception.TheaterException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class TicketOfficeTest {

    @Test
    @DisplayName("티켓 판매원을 생성한다.")
    public void createTicketSeller() throws Exception {
        // given
        ArrayList<TicketSeller> ticketSellers = Stream.of(new TicketSeller(Status.WAITING))
                .collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Ticket> tickets = Stream.of(new Ticket(1000L))
                .collect(Collectors.toCollection(ArrayList::new));
        TicketOffice ticketOffice = new TicketOffice(ticketSellers, tickets);

        // when
        List<TicketSeller> ticketSeller = ticketOffice.createTicketSeller(5);

        // then
        assertThat(ticketSeller)
                .size().isEqualTo(5);
        assertThat(ticketSeller.stream().findAny().orElse(null))
                .isExactlyInstanceOf(TicketSeller.class);
    }

    @Test
    @DisplayName("티켓 판매원을 리스트에 추가한다.")
    public void setTicketSeller() throws Exception {
        // given
        ArrayList<TicketSeller> ticketSellers = Stream.of(new TicketSeller(Status.WAITING))
                .collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Ticket> tickets = Stream.of(new Ticket(1000L))
                .collect(Collectors.toCollection(ArrayList::new));
        TicketOffice ticketOffice = new TicketOffice(ticketSellers, tickets);

        // when
        List<TicketSeller> ticketSeller = ticketOffice.createTicketSeller(2);
        ticketSeller.forEach(ticketOffice::setTicketSeller);

        // then
        assertThat(ticketOffice.getTicketSellers())
                .size().isEqualTo(3);
    }

    @Test
    @DisplayName("티켓을 생성한다.")
    public void createTicket() throws Exception {
        // given
        ArrayList<TicketSeller> ticketSellers = Stream.of(new TicketSeller(Status.WAITING))
                .collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Ticket> tickets = Stream.of(new Ticket(1000L))
                .collect(Collectors.toCollection(ArrayList::new));
        TicketOffice ticketOffice = new TicketOffice(ticketSellers, tickets);

        // when
        List<Ticket> ticketList = ticketOffice.createTicket(5);

        // then
        assertThat(ticketList.stream()
                .findAny()
                .orElse(null))
                .isExactlyInstanceOf(Ticket.class);
    }

    @Test
    @DisplayName("티켓 오피스에서 티켓을 꺼내오면 티켓 리스트에서 티켓이 하나씩 줄어든다.")
    public void getTicket() throws Exception {
        // given
        ArrayList<TicketSeller> ticketSellers = Stream.of(new TicketSeller(Status.WAITING))
                .collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Ticket> tickets = Stream.of(new Ticket(1000L))
                .collect(Collectors.toCollection(ArrayList::new));
        TicketOffice ticketOffice = new TicketOffice(ticketSellers, tickets);

        // when
        Ticket ticket = ticketOffice.getAvailableTicket();

        // then
        List<Ticket> ticketList = ticketOffice.getTicketList();
        assertThat(ticketList)
                .size().isEqualTo(0);
    }

    @Test
    @DisplayName("티켓 오피스에서 티켓 가격을 얻어온다.")
    public void getTicketPrice() throws Exception {
        // given
        ArrayList<TicketSeller> ticketSellers = Stream.of(new TicketSeller(Status.WAITING))
                .collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Ticket> tickets = Stream.of(new Ticket(1000L))
                .collect(Collectors.toCollection(ArrayList::new));
        TicketOffice ticketOffice = new TicketOffice(ticketSellers, tickets);

        // when
        long ticketPrice = ticketOffice.getTicketPrice();

        // then
        assertThat(ticketPrice).isEqualTo(1000L);
    }

    @Test
    @DisplayName("티켓리스트가 없는데 티켓 가격을 요청하면 에러 반환.")
    public void getTicketPriceWithNoTickets() throws Exception {
        // given
        ArrayList<TicketSeller> ticketSellers = Stream.of(new TicketSeller(Status.WAITING))
                .collect(Collectors.toCollection(ArrayList::new));
        TicketOffice ticketOffice = new TicketOffice(ticketSellers, new ArrayList<>());

        // when & then
        assertThat(ticketOffice.getTicketList()).size().isEqualTo(0);
        assertThatThrownBy(ticketOffice::getTicketPrice).isExactlyInstanceOf(TheaterException.class);
    }

    @Test
    @DisplayName("쉬고있는 티켓 판매원을 반환한다.")
    public void findAvailableTicketSeller() throws Exception {
        // given
        ArrayList<TicketSeller> ticketSellers = Stream.of(new TicketSeller(Status.WAITING))
                .collect(Collectors.toCollection(ArrayList::new));
        TicketOffice ticketOffice = new TicketOffice(ticketSellers, new ArrayList<>());

        // when
        TicketSeller availableTicketSeller = ticketOffice.findAvailableTicketSeller();

        // then
        assertThat(ticketSellers.get(0)).isEqualTo(availableTicketSeller);
    }

    @Test
    @DisplayName("쉬고있는 티켓 판매원이 없으면 에러를 반환한다.")
    public void findAvailableTicketSellerWithException() throws Exception {
        // given
        ArrayList<TicketSeller> ticketSellers = Stream.of(new TicketSeller(Status.WORKING))
                .collect(Collectors.toCollection(ArrayList::new));
        TicketOffice ticketOffice = new TicketOffice(ticketSellers, new ArrayList<>());

        // when & then
        assertThatThrownBy(ticketOffice::findAvailableTicketSeller).isExactlyInstanceOf(TheaterException.class);
    }

    @Test
    @DisplayName("티켓을 티켓 리스트에 추가한다.")
    public void setTicket() throws Exception {
        // given
        ArrayList<TicketSeller> ticketSellers = Stream.of(new TicketSeller(Status.WORKING))
                .collect(Collectors.toCollection(ArrayList::new));
        TicketOffice ticketOffice = new TicketOffice(ticketSellers, new ArrayList<>());

        // when
        Ticket newTicket = new Ticket(10000L);
        ticketOffice.setTicket(newTicket);

        // then
        assertThat(ticketOffice.getTicketList().get(0))
                .isEqualTo(newTicket);
    }

    @Test
    @DisplayName("판매금액을 감소시킨다.")
    public void minusAmount() throws Exception {
        // given
        ArrayList<TicketSeller> ticketSellers = Stream.of(new TicketSeller(Status.WORKING))
                .collect(Collectors.toCollection(ArrayList::new));
        TicketOffice ticketOffice = new TicketOffice(ticketSellers, new ArrayList<>(), 10000L);

        // when
        ticketOffice.minusAmount(10000L);

        // then
        assertThat(ticketOffice.getAmount()).isEqualTo(0L);
    }

    @Test
    @DisplayName("판매금액을 증가시킨다.")
    public void plusAmount() throws Exception {
        // given
        ArrayList<TicketSeller> ticketSellers = Stream.of(new TicketSeller(Status.WORKING))
                .collect(Collectors.toCollection(ArrayList::new));
        TicketOffice ticketOffice = new TicketOffice(ticketSellers, new ArrayList<>(), 0L);

        // when
        ticketOffice.plusAmount(10000L);

        // then
        assertThat(ticketOffice.getAmount()).isEqualTo(10000L);
    }

}