export class PgService {
  constructor() {}

  paymentApprove(amount: bigint) {
    console.log('Payment Request SUCCESS, amount :', amount);
    return true;
  }

  paymentCancel(amount: bigint) {
    console.log('Payment Cancel SUCCESS, amount :', amount);
    return false;
  }
}
