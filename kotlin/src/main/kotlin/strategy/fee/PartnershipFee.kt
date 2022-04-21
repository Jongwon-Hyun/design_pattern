package strategy.fee

class PartnershipFee : Fee {
    companion object {
        const val FEE = 0.01
    }

    override fun calculate(amount: Double): Double {
        return amount * FEE
    }
}