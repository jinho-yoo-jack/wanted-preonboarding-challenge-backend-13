import { TicketOffice } from './ticket-office.entity';

export class TicketSeller {
  constructor(private readonly _ticketOffice: TicketOffice) {}

  get ticketOffice() {
    return this._ticketOffice;
  }
}
