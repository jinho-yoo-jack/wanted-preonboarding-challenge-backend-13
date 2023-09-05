import { Expose, Type } from 'class-transformer';
import { WalletDto } from './wallet.dto';
import { User } from '../entity/user.entity';
import { IsNotEmptyObject, ValidateNested } from 'class-validator';

export class UserDto {
  @Expose()
  @IsNotEmptyObject()
  @ValidateNested()
  @Type(() => WalletDto)
  wallet: WalletDto;

  constructor() {}

  static from(wallet: WalletDto) {
    const dto = new UserDto();
    dto.wallet = wallet;

    return dto;
  }

  toEntity(): User {
    return User.from({ props: { wallet: this.wallet.toEntity() } });
  }
}
