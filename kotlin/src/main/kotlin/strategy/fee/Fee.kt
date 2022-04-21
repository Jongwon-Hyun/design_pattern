package strategy.fee

interface Fee {
    fun calculate(amount: Double): Double
}