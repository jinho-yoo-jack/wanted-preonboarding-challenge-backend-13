export const Rank = {
  0: 'Beginner',
  1: 'Middle',
  2: 'Master',
} as const;

export const Status = {
  0: 'Waiting',
  1: 'Making',
} as const;

export type Rank = (typeof Rank)[keyof typeof Rank];
export type Status = (typeof Status)[keyof typeof Status];

export class Barista {
  constructor(
    private _rank: Rank,
    private _status: Status,
  ) {}

  set rank(rank: Rank) {
    this._rank = rank;
  }

  set status(status: Status) {
    this._status = status;
  }

  makeCoffeeTo(orders: Map<string, number>): string {
    const makeOrders = [];

    for (const [coffeeName, quantity] of orders) {
      makeOrders.push(`${coffeeName}:${quantity}`);
    }

    return makeOrders.join();
  }
}
