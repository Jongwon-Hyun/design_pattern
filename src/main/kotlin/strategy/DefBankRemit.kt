package strategy

import strategy.fee.Fee

class DefBankRemit(fee: Fee) : Remit(fee) {
    override fun createTransferMessage(): String {
        return "Def Bank! I will send the money! give me result!"
    }
}