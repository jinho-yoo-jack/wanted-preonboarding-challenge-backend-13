import dayjs from 'dayjs';
import { BaseEntity, CreateEntityProps } from '../base/base.entity';

//todo 초대권이 여러개일 수 있음. 그 중 오늘 날짜의 초대권이 있는지 확인해야 함.

export interface InvitationProps {
  id?: string;
  name: string;
  when: dayjs.Dayjs;
}

export class Invitation extends BaseEntity<InvitationProps> {
  constructor({ props }: CreateEntityProps<InvitationProps>) {
    super({ props });
  }
  static of(props: CreateEntityProps<InvitationProps>) {
    return new Invitation(props);
  }

  getName() {
    return this.props.name;
  }

  getWhen() {
    return this.props.when;
  }
}
