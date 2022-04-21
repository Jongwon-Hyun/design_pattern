import { Discount } from "../discount";

export class WelcomeDiscount implements Discount {
    static readonly RATE = 0.01;
    static readonly HISTORY = "웰컴 할인";
    
    constructor(private readonly discount: Discount) {}

    amountAfterDiscount(amount: number): number {
        return this.discount.amountAfterDiscount(amount) * WelcomeDiscount.RATE;
    }

    history(): string {
        return `${this.discount.history()} ${WelcomeDiscount.HISTORY}`;
    }
    
}