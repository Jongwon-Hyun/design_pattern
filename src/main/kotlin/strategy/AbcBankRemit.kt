package strategy

import strategy.fee.Fee

class AbcBankRemit(fee: Fee) : Remit(fee) {
    override fun createTransferMessage(): String {
        return "Hey Abc Bank! I will give you money! OK?"
    }
}