package theater;

import com.wanted.preonboarding.theater.service.TheaterService;
import com.wanted.preonboarding.theater.service.handler.*;
import org.junit.jupiter.api.Test;

public class AudienceEnterTheater {

    @Test
    void audienceEnterTheaterWithoutTicket() { // 티켓이 없는경우

        TicketOffice ticketOffice = new TicketOffice(0L, new Ticket(3500L));
        Audience audience = new Audience(new Bag(50000));
        TicketSeller ticketSeller = new TicketSeller(ticketOffice);

        TheaterService theaterService = new TheaterService();

        theaterService.enter(audience, ticketSeller);
    }

    @Test
    void audienceEnterTheaterWithTicket() { // 티켓이 있는경우

        TicketOffice ticketOffice = new TicketOffice(0L, new Ticket(3500L));
        Audience audience = new Audience(new Bag(50000));

        TicketSeller ticketSeller = new TicketSeller(ticketOffice);

        TheaterService theaterService = new TheaterService();

        Ticket ticket = ticketSeller.getTicketOffice().getTicket();

        audience.getBag().setTicket(ticket);

        theaterService.enter(audience, ticketSeller);
    }

    @Test
    void audienceEnterTheaterWithInvitation() { // 티켓이 있는경우

        TicketOffice ticketOffice = new TicketOffice(0L, new Ticket(3500L));
        Audience audience = new Audience(new Bag(new Invitation(),50000));

        TicketSeller ticketSeller = new TicketSeller(ticketOffice);

        TheaterService theaterService = new TheaterService();

        theaterService.enter(audience, ticketSeller);
    }
}
