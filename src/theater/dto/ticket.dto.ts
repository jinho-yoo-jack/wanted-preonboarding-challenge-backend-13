import { Expose, Transform } from 'class-transformer';
import { IsNotEmpty } from 'class-validator';
import { Ticket } from '../entity/ticket.entity';
import * as dayjs from 'dayjs';

export class TicketDto {
  @Expose()
  @IsNotEmpty()
  name: string;

  @Expose()
  @IsNotEmpty()
  @Transform((property) => BigInt(property.value))
  fee: bigint;

  @Expose()
  @IsNotEmpty()
  @Transform((property) => {
    return dayjs(property.value);
  })
  when: dayjs.Dayjs;

  constructor() {}

  toEntity(): Ticket {
    return Ticket.from({
      props: { name: this.name, fee: this.fee, when: this.when },
    });
  }
}
