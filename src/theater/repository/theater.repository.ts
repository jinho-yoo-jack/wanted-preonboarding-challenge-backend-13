import { Injectable } from '@nestjs/common';
import { Theater } from './../entity/theater.entity';
import { BaseRepository } from '../base/base.repository';
import { TicketSellerRepository } from './ticket-seller.repository';
import { Seat } from '../entity/seat.entity';

@Injectable()
export class TheaterRepository extends BaseRepository<Theater> {
  constructor() {
    const inMemoryRepository = [
      new Theater({
        props: {
          ticketSeller: new TicketSellerRepository().getRepository()[0],
          seats: Array.from(
            { length: 10 },
            (_, i) => new Seat({ id: (i + 1).toString() }),
          ),
        },
      }),
    ];
    super(inMemoryRepository);
  }
}
