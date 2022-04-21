import { Discount } from "./discount";

export class VipDiscount implements Discount {
    static readonly RATE = 0.05;
    static readonly HISTORY = "VIP 할인";

    amountAfterDiscount(amount: number): number {
        return amount * VipDiscount.RATE;
    }

    history(): string {
        return VipDiscount.HISTORY;
    }
}