import { BadRequestException, Injectable } from '@nestjs/common';
import { TicketOffice } from './ticket-office.entity';
import { Ticket } from './ticket.entity';
import { User } from './user.entity';
import { Message } from '../types/seller-message.type';
import * as dayjs from 'dayjs';
import { BaseEntity, CreateEntityProps } from '../base/base.entity';

//todo 완료 복잡한 getter 메소드로 묶기
//todo 완료 티켓과 초대권의 시간이 일치하는지 검증해야함.
//todo 완료 티켓과 초대권의 이름이 일치하는지 검증해야함.

interface TicketSellerProps {
  ticketOffice: TicketOffice;
}
@Injectable()
export class TicketSeller extends BaseEntity<TicketSellerProps> {
  private message: typeof Message;
  constructor({ props }: CreateEntityProps<TicketSellerProps>) {
    super({ props });
  }

  static from(props: CreateEntityProps<TicketSellerProps>) {
    return new TicketSeller(props);
  }

  enter(user: User) {
    const { invitationValidationResult, invitationId, ticketId } =
      this.validateInvitationsOf(user);

    invitationValidationResult
      ? this.exchangeTicket(user, ticketId, invitationId)
      : this.sellTicket(user, ticketId);
    //todo 어찌보면 위의 로직은 현재 입장 가능한 영화에 대한 검증이 아니라 단순히 초대권과 영화 티켓정보가 일치하면 교환, 아니면 판매 로직임. 따라서, 현재 입장 가능한 영화의 티켓을 가지고 있는지 검증 하는 로직으로 수정해야함. 해당 로직은 바로 위에 exchange나 sell에서 검증하면 됨.

    const ticketsFromUser = user.getWallet().getTickets();

    ticketsFromUser.map((ticket: Ticket) => {
      const ticketWhen = ticket.getWhen();
      const isBeforeMovieScreeningTime = dayjs().isBefore(ticketWhen);
      const beforeThanThirtyMinutes = dayjs().diff(ticketWhen, 'minutes') < 30;

      return isBeforeMovieScreeningTime && beforeThanThirtyMinutes; // todo 하나의 함수로 묶어주는 것이 좋음
    });

    return this.greetTo(user);
  }

  getTicketsFromOffice() {
    return this.getTicketOffice().getTickets();
  }

  private getTicketOffice() {
    return this.props.ticketOffice;
  }

  private getTicketById(ticketId: string) {
    return this.getTicketOffice().getTicketById(ticketId);
  }

  validateInvitationsOf(user: User) {
    const invitations = user.getWallet().getInvitations();
    const ticketsFromOffice: Ticket[] = this.getTicketsFromOffice();

    let isSameWhen = false;
    let isSameName = false;
    let i: number;
    let j: number;
    let ticketId: string;
    let invitationId: string;

    outerLoop: for (i = 0; i < invitations.length; i++) {
      for (j = 0; j < ticketsFromOffice.length; j++) {
        isSameName =
          invitations[i].getName() === ticketsFromOffice[j].getName();
        isSameWhen = dayjs(invitations[i].getWhen()).isSame(
          ticketsFromOffice[j].getWhen(),
        );

        if (!(isSameName && isSameWhen)) {
          invitationId = invitations[i].getId();
          ticketId = ticketsFromOffice[j].getId();
          break outerLoop;
        }
      }
    }
    return {
      invitationValidationResult:
        user.getWallet().hasInvitation() && isSameName && isSameWhen,
      ticketId,
      invitationId,
    };
  }

  exchangeTicket(user: User, ticketId: string, invitationId: string) {
    const ticket = this.getTicketById(ticketId);
    user.getWallet().setTicket(ticket);
    user.getWallet().deleteInvitation(invitationId);
  }

  sellTicket(user: User, ticketId: string) {
    const ticket = this.getTicketById(ticketId);
    if (!this.validateUserBudget(user, ticket))
      throw new BadRequestException('Budget is tight.');

    user.getWallet().minusBalance(ticket.getFee());
    this.getTicketOffice().plusBalance(ticket.getFee());
    this.getTicketOffice().deleteTicket(ticketId);
    user.getWallet().setTicket(ticket);
  }

  private validateUserBudget(user: User, ticket: Ticket) {
    return user.getWallet().getBalance() >= ticket.getFee();
  }

  greetTo(user: User) {
    return user.getWallet().hasTicket()
      ? this.message.ENTRANCE_GREETING
      : this.message.TICKET_PURCHASE_NOTICE;
  }
}
