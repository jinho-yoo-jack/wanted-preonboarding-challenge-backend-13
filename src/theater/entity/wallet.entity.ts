import { CreateEntityProps } from './../base/base.entity';
import { BaseEntity } from '../base/base.entity';
import { Invitation } from './invitation.entity';
import { Ticket } from './ticket.entity';

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

  getInvitation() {
    return this.props.invitations[0];
  }

  getInvitations() {
    return this.props.invitations;
  }

  deleteInvitation(invitationId: string) {
    const invitations = this.getInvitations();
    const invitationIndex = invitations.findIndex(
      (invitation) => invitation.getId() === invitationId,
    );
    invitations.splice(invitationIndex, 1);
  }

  hasInvitation(): boolean {
    return this.props.invitations.length > 0;
  }

  getTicket() {
    return this.props.tickets[0];
  }

  getTickets() {
    return this.props.tickets;
  }

  setTicket(ticket: Ticket) {
    this.props.tickets.push(ticket);
  }

  hasTicket(): boolean {
    return this.props.tickets.length > 0;
  }

  getBalance(): bigint {
    return this.props.balance;
  }

  minusBalance(money: bigint): void {
    this.props.balance -= money;
  }

  plusBalance(money: bigint): void {
    this.props.balance += money;
  }
}
