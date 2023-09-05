import {
  ValidationArguments,
  ValidationOptions,
  registerDecorator,
} from 'class-validator';
import { WalletDto } from '../dto/wallet.dto';

export function HasEnoughBudget(
  property: bigint,
  validationOptions?: ValidationOptions,
) {
  return function (object: object, propertyName: string) {
    registerDecorator({
      name: 'HasEnoughBudget',
      target: object.constructor,
      propertyName,
      async: false,
      constraints: [property],
      options: validationOptions,
      validator: {
        validate(value: bigint, args: ValidationArguments) {
          const [budgetLimit] = args.constraints;
          const { object } = args;
          const wallet = Object.assign(new WalletDto(), object).toEntity();
          const hasInvitations = wallet.hasInvitations();
          const hasTicket = wallet.hasTickets();

          console.log('walletDto: ', wallet);
          // const result =
          //   (object.hasOwnProperty('invitations') &&
          //     object['invitations'].length > 0) ||
          //   (!object.hasOwnProperty('invitations') && value >= budgetLimit);

          return hasTicket || hasInvitations || value >= budgetLimit;
        },
      },
    });
  };
}
