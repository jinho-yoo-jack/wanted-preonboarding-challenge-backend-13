import { CreateEntityProps } from '../../base/base.entity';
import { BaseEntity } from '../../base/base.entity';

interface SeatProps {
  ticketId?: string;
}

export class Seat extends BaseEntity<SeatProps> {
  constructor({ props }: CreateEntityProps<SeatProps>) {
    super({ props });
  }
}
