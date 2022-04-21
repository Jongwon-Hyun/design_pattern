import { AbcBankRemit } from "./abc-bank-remit";
import { DefBankRemit } from "./def-bank-remit";
import { DefaultFee } from "./fee/default-fee";
import { PartnershipFee } from "./fee/partnership-fee";

test('Strategy Run', () => {
    const amount = 10000;
    const defaultFee = amount * DefaultFee.FEE;
    const partnershipFee = amount * PartnershipFee.FEE;
    
    const abcBankRemit = new AbcBankRemit(new DefaultFee());
    const defBankRemit = new DefBankRemit(new PartnershipFee());

    const amountAbc = abcBankRemit.caculateAmount(amount);
    const amountDef = defBankRemit.caculateAmount(amount);

    expect(amountAbc).toEqual(amount + defaultFee);
    expect(amountDef).toEqual(amount + partnershipFee);
});