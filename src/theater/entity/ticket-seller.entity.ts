import { TicketOffice } from './ticket-office.entity';
import { Ticket } from './ticket.entity';
import { User } from './user.entity';
import { Message } from '../types/seller-message.type';
import { BaseEntity, CreateEntityProps } from '../../base/base.entity';
import { Invitation } from './invitation.entity';

// 완료 복잡한 getter 메소드로 묶기
//todo 티켓과 초대권의 시간이 일치하는지 검증해야함.
//todo 티켓과 초대권의 이름이 일치하는지 검증해야함.

interface TicketSellerProps {
  ticketOffice: TicketOffice;
}
export class TicketSeller extends BaseEntity<TicketSellerProps> {
  private message: typeof Message = Message;
  constructor({ props }: CreateEntityProps<TicketSellerProps>) {
    super({ props });
  }

  enter(user: User, number: number = 1) {
    if (!user.hasTickets(number)) this.sellTicketsTo(user, number);

    user.submitTickets(number);

    return this.message.ENTRANCE_GREETING;
  }

  static from(props: CreateEntityProps<TicketSellerProps>) {
    return new TicketSeller(props);
  }

  private exchangeTicketTo(user: User, invitations: Invitation[]) {
    const tickets = this.props.ticketOffice.publishTickets(invitations.length);
    user.setTickets(tickets);
  }

  private sellTicketsTo(user: User, number: number = 0) {
    const tickets = this.props.ticketOffice.publishTickets(number);
    if (user.hasInvitations(number)) {
      this.exchangeTicketTo(user, user.submitInvitations(number));
      return;
    }

    user.buyTickets(tickets);
    this.receiveCostOf(tickets);
  }

  private receiveCostOf(tickets: Ticket[]) {
    this.props.ticketOffice.plusBalance(...tickets);
  }
}
