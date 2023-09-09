import { CreateEntityProps } from '../base/base.entity';
import { BaseEntity } from '../base/base.entity';
import { Invitation } from './invitation.entity';
import { Ticket } from './ticket.entity';
import { BadRequestException } from '@nestjs/common';

interface WalletProps {
  balance: bigint;
  invitations?: Invitation[];
  tickets?: Ticket[];
}

export class Wallet extends BaseEntity<WalletProps> {
  constructor({ props }: CreateEntityProps<WalletProps>) {
    super({ props });
  }
  static of(props: CreateEntityProps<WalletProps>) {
    return new Wallet(props);
  }

  takeInvitationsOutOf(number: number): Invitation[] {
    return this.props.invitations.splice(0, number);
  }

  takeTicketsOutOf(number: number): Ticket[] {
    return this.props.tickets.splice(0, number);
  }

  hasInvitations(number: number = 1): boolean {
    return this.props.invitations.length >= number;
  }

  hasTickets(number: number = 1): boolean {
    return this.props.tickets.length >= number;
  }

  setTickets(tickets: Ticket[]) {
    this.props.tickets.push(...tickets);
  }

  minusBalance(...tickets: Ticket[]): void {
    let totalCost: bigint = 0n;

    tickets.forEach((ticket) => (totalCost += ticket.getFee()));

    if (!this.hasEnoughBalance(totalCost))
      throw new BadRequestException('User has no enough budget.');

    this.props.balance -= totalCost;
    console.log('현재 유저 남은 예산', this.props.balance);
  }

  plusBalance(...tickets: Ticket[]): void {
    tickets.forEach((ticket) => (this.props.balance += ticket.getFee()));
  }

  private hasEnoughBalance(neededBalance: bigint): boolean {
    return this.props.balance >= neededBalance;
  }
}
