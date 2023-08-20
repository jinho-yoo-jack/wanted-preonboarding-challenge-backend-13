import { Invitation } from './invitation.entity';
import { Ticket } from './ticket.entity';
export class Bag {
  private _ticket: Ticket;

  constructor(
    private _amount: bigint,
    private readonly _invitation?: Invitation,
  ) {}

  hasInvitation(): boolean {
    return this._invitation !== null;
  }

  hasTicket(): boolean {
    return this._ticket !== null;
  }

  set ticket(ticket: Ticket) {
    this._ticket = ticket;
  }

  minusAmount(amount: bigint): void {
    this._amount -= amount;
  }

  plusAmount(amount: bigint): void {
    this._amount += amount;
  }
}
