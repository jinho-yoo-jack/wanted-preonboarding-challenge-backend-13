import { Expose, Transform, Type } from 'class-transformer';
import { InvitationDto } from './invitationDto';
import { TicketDto } from './ticket.dto';
import { IsNotEmpty, IsOptional, ValidateNested } from 'class-validator';
import { Wallet } from '../entity/wallet.entity';
import { HasEnoughBudget } from '../decorator/has-enough-budget.decorator';
import { MIN_BUDGET } from '../entity/ticket-office.entity';

export class WalletDto {
  // 최소 예산 100n이 유동적으로 변할 수 있어야 함. 세일 가능성.
  @Expose()
  @IsNotEmpty()
  @Transform((property) => BigInt(property.value))
  @HasEnoughBudget(MIN_BUDGET, {
    message: `초대장 또는 티켓이 없다면 적어도 예산이 ${MIN_BUDGET} 이상 있어야 합니다.`,
  })
  balance: bigint;

  @Expose()
  @IsOptional()
  @ValidateNested()
  @Type(() => InvitationDto)
  invitations?: InvitationDto[];

  @Expose()
  @IsOptional()
  @ValidateNested()
  @Type(() => TicketDto)
  tickets?: TicketDto[];

  constructor() {}

  toEntity(): Wallet {
    return Wallet.of({
      props: {
        balance: this.balance,
        invitations: this.invitations?.map((invitation) =>
          invitation.toEntity(),
        ),
        tickets: this.tickets?.map((ticket) => ticket.toEntity()),
      },
    });
  }
}
