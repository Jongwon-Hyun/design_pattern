package strategy

import strategy.fee.Fee

abstract class Remit(private val fee: Fee) {
    protected abstract fun createTransferMessage(): String

    fun calculateAmount(amount: Double): Double {
        return amount + calculateFee(amount)
    }

    private fun calculateFee(amount: Double): Double {
        return fee.calculate(amount)
    }
}