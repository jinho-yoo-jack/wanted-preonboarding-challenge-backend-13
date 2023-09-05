import { Injectable } from '@nestjs/common';
import { BaseRepository } from '../base/base.repository';
import { TicketOffice } from '../entity/ticket-office.entity';
import { TicketRepository } from './ticket.repository';

@Injectable()
export class TicketOfficeRepository extends BaseRepository<TicketOffice> {
  constructor() {
    const inMemoryRepository = [
      new TicketOffice({
        props: {
          balance: 1000n,
          tickets: new TicketRepository().getRepository(),
        },
      }),
    ];
    super(inMemoryRepository);
  }
}
