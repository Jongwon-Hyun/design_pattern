package strategy.fee

class DefaultFee : Fee {
    companion object {
        const val FEE = 0.03
    }

    override fun calculate(amount: Double): Double {
        return amount * FEE
    }
}