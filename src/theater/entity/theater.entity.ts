import { Injectable } from '@nestjs/common';
import { Audience } from './audience.entity';
import { TicketSeller } from './ticket-seller.entity';
import { Ticket } from './ticket.entity';

@Injectable()
export class Theater {
  enter(audience: Audience, ticketSeller: TicketSeller): void {
    if (audience.bag.hasInvitation()) {
      const ticket: Ticket = ticketSeller.ticketOffice.ticket;
      audience.bag.ticket = ticket;
    } else {
      const ticket: Ticket = ticketSeller.ticketOffice.ticket;
      audience.bag.minusAmount(ticket.fee);
      ticketSeller.ticketOffice.plusAmount(ticket.fee);
      audience.bag.ticket = ticket;
    }
  }
}
