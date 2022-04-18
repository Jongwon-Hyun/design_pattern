package strategy.fee

interface Fee {
    fun calculate(amount: Double): Double

    companion object {
        const val DEFAULT_FEE = 0.03
        const val PARTNERSHIP_FEE = 0.01
    }
}