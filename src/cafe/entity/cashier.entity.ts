import { Barista, Rank, Status } from './barista.entity';
import { Cafe } from './cafe.entity';

export class Cashier {
  constructor(private readonly cafe: Cafe) {}

  calculateTotalPrice(orders: Map<string, number>): bigint {
    let totalPrice = 0n;
    const americanoPrice = 100n;

    for (const [coffeeName, quantity] of orders) {
      if (coffeeName === 'AMERICANO')
        totalPrice += americanoPrice * BigInt(quantity);
    }

    return totalPrice;
  }

  sendTo(barista: Barista, receivedOrders: Map<string, number>): string {
    return barista.makeCoffeeTo(receivedOrders);
  }

  takeOrder(receivedOrders: Map<string, number>, totalPrice: bigint): string {
    this.cafe.plusSales(totalPrice);

    return this.sendTo(new Barista(Rank[0], Status[0]), receivedOrders);
  }
}
