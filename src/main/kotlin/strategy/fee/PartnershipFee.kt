package strategy.fee

class PartnershipFee : Fee {
    override fun calculate(amount: Double): Double {
        return amount * Fee.PARTNERSHIP_FEE
    }
}