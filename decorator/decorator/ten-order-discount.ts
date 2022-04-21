import { Discount } from "../discount";

export class TenOrderDiscount implements Discount {
    static readonly RATE = 0.02;
    static readonly HISTORY = "10번 주문 할인";
    
    constructor(private readonly discount: Discount) {}
    
    amountAfterDiscount(amount: number): number {
        return this.discount.amountAfterDiscount(amount) * TenOrderDiscount.RATE;
    }

    history(): string {
        return `${this.discount.history()} ${TenOrderDiscount.HISTORY}` ;
    }
}