import { Injectable } from '@nestjs/common';

@Injectable()
export class Cafe {
  private readonly _name: string;
  private sales: bigint;

  constructor() {
    this._name = 'wantedCodingCafe';
    this.sales = 10000n;
  }

  get cafeName() {
    return this._name;
  }

  plusSales(amount: bigint): void {
    this.sales += amount;
  }

  minusSales(amount: bigint): void {
    this.sales -= amount;
  }
}
