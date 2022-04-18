package strategy.fee

class DefaultFee : Fee {
    override fun calculate(amount: Double): Double {
        return amount * Fee.DEFAULT_FEE
    }
}