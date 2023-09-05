import { BaseEntity } from '../base/base.entity';

interface SeatProps {
  ticketId?: string;
}

export class Seat extends BaseEntity<SeatProps> {}
