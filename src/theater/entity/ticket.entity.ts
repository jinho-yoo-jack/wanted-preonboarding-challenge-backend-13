import dayjs from 'dayjs';
import { BaseEntity, CreateEntityProps } from '../base/base.entity';

interface TicketProps {
  name: string;
  fee: bigint;
  when: dayjs.Dayjs;
}

export class Ticket extends BaseEntity<TicketProps> {
  constructor({ props }: CreateEntityProps<TicketProps>) {
    super({ props });
  }
  static from(props: CreateEntityProps<TicketProps>) {
    return new Ticket(props);
  }

  getName() {
    return this.props.name;
  }

  getFee() {
    return this.props.fee;
  }

  getWhen() {
    return this.props.when;
  }
}
