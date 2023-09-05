import { CreateEntityProps } from '../base/base.entity';
import { BaseEntity } from '../base/base.entity';
import { Wallet } from './Wallet.entity';

//todo 완료 BaseEntity 상속
interface UserProps {
  wallet: Wallet;
}

export class User extends BaseEntity<UserProps> {
  constructor({ props }: CreateEntityProps<UserProps>) {
    super({ props });
  }
  getWallet() {
    return this.props.wallet;
  }

  static from(props: CreateEntityProps<UserProps>) {
    return new User(props);
  }
}
