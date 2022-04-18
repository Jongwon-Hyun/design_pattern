import { DEFAULT_FEE, Fee } from "./fee";


export class DefaultFee implements Fee {
    calculate(amount: number): number {
        const a = amount * DEFAULT_FEE;
        return amount * DEFAULT_FEE;
    }
}