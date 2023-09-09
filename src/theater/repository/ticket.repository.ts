import { Injectable } from '@nestjs/common';
import { BaseRepository } from '../base/base.repository';
import { Ticket } from '../entity/ticket.entity';
import * as dayjs from 'dayjs';

@Injectable()
export class TicketRepository extends BaseRepository<Ticket> {
  constructor() {
    const oppenheimerTickets = Array.from(
      { length: 10 },
      (_, i) =>
        new Ticket({
          id: (i + 1).toString(),
          props: {
            name: '오펜하이머',
            fee: 100n,
            when: dayjs().add(15, 'minute'),
          },
        }),
    );

    const ticketsAfterOneMonth = Array.from(
      { length: 10 },
      (_, i) =>
        new Ticket({
          id: (i + 11).toString(),
          props: {
            name: '한달 뒤 개봉 영화',
            fee: 150n,
            when: dayjs().add(1, 'month'),
          },
        }),
    );

    const inMemoryRepository = [...oppenheimerTickets, ...ticketsAfterOneMonth];
    super(inMemoryRepository);
  }
}
