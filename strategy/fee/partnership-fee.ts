import { Fee } from "./fee";

export class PartnershipFee implements Fee {
    static readonly FEE = 0.01;

    calculate(amount: number): number {
        return amount * PartnershipFee.FEE;
    }
}