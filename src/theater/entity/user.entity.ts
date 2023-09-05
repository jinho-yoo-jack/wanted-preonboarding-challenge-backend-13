import { BadRequestException } from '@nestjs/common';
import { CreateEntityProps } from '../../base/base.entity';
import { BaseEntity } from '../../base/base.entity';
import { Wallet } from './Wallet.entity';
import { Ticket } from './ticket.entity';

//todo 완료 BaseEntity 상속
interface UserProps {
  wallet: Wallet;
}

export class User extends BaseEntity<UserProps> {
  constructor({ props }: CreateEntityProps<UserProps>) {
    super({ props });
  }

  buyTickets(tickets: Ticket[]) {
    this.props.wallet.minusBalance(...tickets);
    this.setTickets(tickets);
  }

  submitInvitations(number: number = 1) {
    if (!this.props.wallet.hasInvitations(number))
      throw new BadRequestException('User has no enough invitations.');
    return this.props.wallet.takeInvitationsOutOf(number);
  }

  submitTickets(number: number = 1) {
    if (!this.props.wallet.hasTickets(number))
      throw new BadRequestException("User's has no enough tickets.");

    this.props.wallet.takeTicketsOutOf(number);
  }

  setTickets(tickets: Ticket[]) {
    this.props.wallet.setTickets(tickets);
  }

  hasTickets(number: number = 1) {
    return this.props.wallet.hasTickets(number);
  }

  hasInvitations(number: number = 1) {
    return this.props.wallet.hasInvitations(number);
  }

  static from(props: CreateEntityProps<UserProps>) {
    return new User(props);
  }
}
