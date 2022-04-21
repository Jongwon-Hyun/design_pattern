import { Discount } from "./discount";

export class StudentDiscount implements Discount {
    static readonly RATE = 0.03;
    static readonly HISTORY = "학생 할인"

    amountAfterDiscount(amount: number): number {
        return amount * StudentDiscount.RATE;
    }

    history(): string {
        return StudentDiscount.HISTORY;
    }
    
}