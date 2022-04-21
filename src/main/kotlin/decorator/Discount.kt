package decorator

interface Discount {
    fun amountAfterDiscount(amount: Double): Double
    fun history(): String
}