export class Ticket {
  constructor(private _fee: bigint) {}

  get fee() {
    return this._fee;
  }
}
