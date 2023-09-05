import {
  ValidationArguments,
  ValidationOptions,
  registerDecorator,
} from 'class-validator';

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

          return (
            object.hasOwnProperty('invitation') ||
            (!object.hasOwnProperty('invitation') && value >= budgetLimit)
          );
        },
      },
    });
  };
}
