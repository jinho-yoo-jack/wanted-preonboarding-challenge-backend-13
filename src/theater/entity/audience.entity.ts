import { Bag } from './bag.entity';

export class Audience {
  constructor(private readonly _bag: Bag) {}

  get bag() {
    return this._bag;
  }
}
