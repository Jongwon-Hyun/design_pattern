import { Fee } from "./fee";


export class DefaultFee implements Fee {
    static readonly FEE = 0.03

    calculate(amount: number): number {
        const a = amount * DefaultFee.FEE;
        return amount * DefaultFee.FEE;
    }
}