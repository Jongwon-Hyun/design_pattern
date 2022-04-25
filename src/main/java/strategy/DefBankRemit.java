package strategy;

import strategy.fee.Fee;

public class DefBankRemit extends Remit {
    public DefBankRemit(Fee fee) {
        super(fee);
    }

    @Override
    public String createTransferMessage() {
        return "Def Bank! I will send the money! give me result!";
    }
}
