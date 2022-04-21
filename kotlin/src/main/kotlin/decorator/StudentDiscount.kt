package decorator

class StudentDiscount: Discount {
    companion object {
        const val RATE = 0.03
        const val HISTORY = "학생 할인"
    }

    override fun amountAfterDiscount(amount: Double): Double {
        return amount * RATE
    }

    override fun history(): String {
        return HISTORY
    }
}