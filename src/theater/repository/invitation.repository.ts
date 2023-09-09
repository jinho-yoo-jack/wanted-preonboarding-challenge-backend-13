import { Injectable } from '@nestjs/common';
import { BaseRepository } from '../base/base.repository';
import { Invitation } from '../entity/invitation.entity';
import * as dayjs from 'dayjs';

@Injectable()
export class InvitationRepository extends BaseRepository<Invitation> {
  constructor() {
    const inMemoryRepository = [
      new Invitation({
        id: '1',
        props: { name: '오펜하이머', when: dayjs().add(15, 'minute') },
      }),
      new Invitation({
        id: '2',
        props: { name: '한달 뒤 개봉 영화', when: dayjs().add(1, 'month') },
      }),
    ];
    super(inMemoryRepository);
  }
}
