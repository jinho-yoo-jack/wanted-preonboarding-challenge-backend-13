import { Ticket } from './ticket.entity';
import { BaseEntity, CreateEntityProps } from '../base/base.entity';

//todo 완료 ticketOffice에 constructor 추가. 기본 티켓 수 레포지토리에 추가하기.
//todo 완료 TicketRepository 필요하면 setter로 주입.
export const MIN_BUDGET = 100n;
interface TicketOfficeProps {
  balance: bigint;
  tickets: Ticket[];
}

export class TicketOffice extends BaseEntity<TicketOfficeProps> {
  constructor({ props }: CreateEntityProps<TicketOfficeProps>) {
    super({ props });
  }
  static of(props: CreateEntityProps<TicketOfficeProps>) {
    return new TicketOffice(props);
  }

  publishTickets(number: number = 1) {
    return this.props.tickets.splice(0, number);
  }

  minusBalance(...tickets: Ticket[]): void {
    tickets.forEach((ticket) => (this.props.balance -= ticket.getFee()));
  }

  plusBalance(...tickets: Ticket[]): void {
    tickets.forEach((ticket) => (this.props.balance += ticket.getFee()));
  }
}
