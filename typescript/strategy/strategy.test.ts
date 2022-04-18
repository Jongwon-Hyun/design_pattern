import { AbcBankRemit } from "./abc-bank-remit";
import { DefBankRemit } from "./def-bank-remit";
import { DefaultFee } from "./fee/default-fee";
import { DEFAULT_FEE, PARTNERSHIP_FEE } from "./fee/fee";
import { PartnershipFee } from "./fee/partnership-fee";

test('Strategy Run', () => {
    const amount = 10000;
    const defaultFee = amount * DEFAULT_FEE;
    const partnershipFee = amount * PARTNERSHIP_FEE;
    
    const abcBankRemit = new AbcBankRemit(new DefaultFee());
    const defBankRemit = new DefBankRemit(new PartnershipFee());

    const amountAbc = abcBankRemit.caculateAmount(amount);
    const amountDef = defBankRemit.caculateAmount(amount);

    expect(amountAbc).toEqual(amount + defaultFee);
    expect(amountDef).toEqual(amount + partnershipFee);
});