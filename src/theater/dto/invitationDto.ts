import { Expose, Transform } from 'class-transformer';
import { IsNotEmpty } from 'class-validator';
import * as dayjs from 'dayjs';
import { Invitation } from '../entity/invitation.entity';

export class InvitationDto {
  @Expose()
  @IsNotEmpty()
  id: string;

  @Expose()
  @IsNotEmpty()
  name: string;

  @Expose()
  @IsNotEmpty()
  @Transform((property) => {
    return dayjs(property.value);
  })
  when: dayjs.Dayjs;

  constructor() {}

  static of(id: string, name: string, when: dayjs.Dayjs) {
    const dto = new InvitationDto();
    dto.id = id;
    dto.name = name;
    dto.when = when;

    return dto;
  }

  toEntity(): Invitation {
    return Invitation.of({
      props: { id: this.id, name: this.name, when: this.when },
    });
  }
}
