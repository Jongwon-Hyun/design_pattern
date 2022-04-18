import { Fee } from "./fee/fee";
import { Remit } from "./remit";

export class DefBankRemit extends Remit {
    constructor(fee: Fee) {
        super(fee)
    }

    public createTransferMessage(): string {
        return "Def Bank! I will send the money! give me result!";
    }
}