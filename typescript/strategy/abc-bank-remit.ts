import { Fee } from "./fee/fee";
import { Remit } from "./remit";

export class AbcBankRemit extends Remit {
    constructor(fee: Fee) {
        super(fee);
    }

    public createTransferMessage(): string {
        return "Hey Abc Bank! I will give you money! OK?";
    }
}