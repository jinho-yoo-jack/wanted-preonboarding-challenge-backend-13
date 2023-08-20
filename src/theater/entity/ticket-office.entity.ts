import { Ticket } from './ticket.entity';

export class TicketOffice {
  private readonly _tickets: Ticket[];

  constructor(
    private _amount: bigint,
    ...tickets: Ticket[]
  ) {
    this._tickets = tickets;
  }

  get ticket() {
    return this._tickets[0];
  }

  minusAmount(amount: bigint): void {
    this._amount -= amount;
  }

  plusAmount(amount: bigint): void {
    this._amount += amount;
  }
}
