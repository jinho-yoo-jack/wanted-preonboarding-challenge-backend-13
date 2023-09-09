import { PgService } from './../infra/pg/pg.service';
import { BadRequestException, Injectable } from '@nestjs/common';
import { PaymentMethod } from './customer.entity';

export const Menu = {
  AMERICANO: 100n,
  LATTE: 120n,
  ICE_TEA: 100n,
} as const;

@Injectable()
export class Cafe {
  private sales: bigint;
  private readonly menu: typeof Menu;

  constructor(private readonly pgService: PgService) {
    this.sales = 10000n;
    this.menu = Menu;
  }

  getPrice(menuName: string) {
    return this.isExistMenu(menuName) ? this.menu[menuName] : 0n;
  }

  plusSales(amount: bigint, paymentMethod: PaymentMethod): void {
    if (!this.isAllowedPaymentMethod(paymentMethod))
      throw new BadRequestException(
        `Not Allowed Payment Method: ${paymentMethod}`,
      );

    this.paymentApprove(amount, paymentMethod);
  }

  minusSales(amount: bigint, paymentMethod: PaymentMethod): void {
    if (!this.isAllowedPaymentMethod(paymentMethod))
      throw new BadRequestException(
        `Not Allowed Payment Method: ${paymentMethod}`,
      );

    this.paymentCancel(amount, paymentMethod);
  }

  private isExistMenu(menuName: string) {
    return Object.keys(this.menu).includes(menuName.toUpperCase());
  }

  private paymentApprove(amount: bigint, paymentMethod: string) {
    switch (paymentMethod) {
      case PaymentMethod.CARD:
        this.pgService.paymentApprove(amount);
        break;

      case PaymentMethod.CASH:
        this.sales += amount;
        break;
    }
  }

  private paymentCancel(amount: bigint, paymentMethod: PaymentMethod) {
    switch (paymentMethod.toUpperCase()) {
      case PaymentMethod.CARD:
        this.pgService.paymentCancel(amount);
        break;

      case PaymentMethod.CASH:
        this.sales -= amount;
        break;
    }
  }

  private isAllowedPaymentMethod(paymentMethod: string) {
    return paymentMethod in PaymentMethod;
  }
}
