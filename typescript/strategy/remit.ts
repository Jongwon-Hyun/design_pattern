import { Fee } from "./fee/fee";

export abstract class Remit {
    constructor(private fee: Fee) {}

    abstract createTransferMessage(): string;

    public caculateAmount(amount: number): number {
        const a = this.calculateFee(amount);
        return amount + this.calculateFee(amount);
    }

    private calculateFee(amount: number): number {
        return this.fee.calculate(amount);
    }
}