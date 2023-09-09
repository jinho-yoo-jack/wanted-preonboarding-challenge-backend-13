import { Injectable } from '@nestjs/common';
import { Barista } from './barista.entity';
import { Cafe } from './cafe.entity';
import { PaymentMethod } from './customer.entity';

@Injectable()
export class Cashier {
  constructor(
    private readonly cafe: Cafe,
    private readonly barista: Barista,
  ) {}

  takeOrder(
    receivedOrders: Map<string, number>,
    paymentMethod: PaymentMethod,
  ): string {
    const totalPrice: bigint = this.calculateTotalPrice(receivedOrders);

    this.cafe.plusSales(totalPrice, paymentMethod);

    return this.barista.makeCoffeeTo(receivedOrders);
  }

  private calculateTotalPrice(orders: Map<string, number>): bigint {
    let totalPrice = 0n;

    for (const [menuName, quantity] of orders) {
      totalPrice += this.cafe.getPrice(menuName) * BigInt(quantity);
    }

    return totalPrice;
  }
}
