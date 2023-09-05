import { Injectable } from '@nestjs/common';
import { Ticket } from './ticket.entity';
import { BaseEntity, CreateEntityProps } from '../base/base.entity';

//todo 완료 ticketOffice에 constructor 추가. 기본 티켓 수 레포지토리에 추가하기.
//todo 완료 TicketRepository 필요하면 setter로 주입.
export const MIN_BUDGET = 100n;
interface TicketOfficeProps {
  balance: bigint;
  tickets: Ticket[];
}

@Injectable()
export class TicketOffice extends BaseEntity<TicketOfficeProps> {
  constructor({ props }: CreateEntityProps<TicketOfficeProps>) {
    super({ props });
  }
  static of(props: CreateEntityProps<TicketOfficeProps>) {
    return new TicketOffice(props);
  }

  getTickets() {
    return this.props.tickets;
  }

  getTicketById(ticketId: string) {
    const index = this.getTickets().findIndex(
      (ticket) => ticket.getId() === ticketId,
    );
    return this.getTickets()[index];
  }

  deleteTicket(ticketId: string) {
    const tickets = this.getTickets();
    const ticketIndex = tickets.findIndex(
      (ticket) => ticket.getId() === ticketId,
    );
    tickets.splice(ticketIndex, 1);
  }

  minusBalance(money: bigint): void {
    this.props.balance -= money;
  }

  plusBalance(money: bigint): void {
    this.props.balance += money;
  }
}
