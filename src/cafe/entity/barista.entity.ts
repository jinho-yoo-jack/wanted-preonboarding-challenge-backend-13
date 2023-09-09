export class Barista {
  constructor() {}

  makeCoffeeTo(orders: Map<string, number>): string {
    const makeOrders = [];

    for (const [coffeeName, quantity] of orders) {
      makeOrders.push(`${coffeeName}:${quantity}`);
    }

    return makeOrders.join();
  }
}
