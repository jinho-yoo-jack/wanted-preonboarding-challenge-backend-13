import { Injectable } from '@nestjs/common';
import { BaseRepository } from '../../base/base.repository';
import { TicketSeller } from '../entity/ticket-seller.entity';
import { TicketOfficeRepository } from './ticket-office.repository';

@Injectable()
export class TicketSellerRepository extends BaseRepository<TicketSeller> {
  constructor() {
    const inMemoryRepository = [
      new TicketSeller({
        props: {
          ticketOffice: new TicketOfficeRepository().getRepository()[0],
        },
      }),
    ];
    super(inMemoryRepository);
  }
}
