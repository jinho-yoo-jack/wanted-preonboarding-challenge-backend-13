import { Injectable } from '@nestjs/common';
import { Theater } from './entity/theater.entity';
import { TicketSeller } from './entity/ticket-seller.entity';
import { Audience } from './entity/audience.entity';
import { Bag } from './entity/bag.entity';
import { TicketOffice } from './entity/ticket-office.entity';
import { Ticket } from './entity/ticket.entity';

@Injectable()
export class TheaterService {
  constructor(private readonly theater: Theater) {}

  enter(): string {
    this.theater.enter(
      new Audience(new Bag(1000n)),
      new TicketSeller(new TicketOffice(20000n, new Ticket(100n))),
    );

    return 'Have a good time.';
  }
}
