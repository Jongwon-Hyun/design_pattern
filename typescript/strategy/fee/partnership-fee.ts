import { Fee, PARTNERSHIP_FEE } from "./fee";

export class PartnershipFee implements Fee {
    calculate(amount: number): number {
        return amount * PARTNERSHIP_FEE;
    }
}