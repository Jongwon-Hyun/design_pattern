package strategy;

import strategy.fee.Fee;

public class AbcBankRemit extends Remit {
    public AbcBankRemit(Fee fee) {
        super(fee);
    }

    @Override
    public String createTransferMessage() {
        return "Hey Abc Bank! I will give you money! OK?";
    }

}
