package decorator.decorator

import decorator.Discount

class WelcomeDiscount(private val discount: Discount): Discount {
    companion object {
        const val RATE = 0.01
        const val HISTORY = "웰컴 할이"
    }

    override fun amountAfterDiscount(amount: Double): Double {
        return discount.amountAfterDiscount(amount) * RATE
    }

    override fun history(): String {
        return "${discount.history()} $HISTORY"
    }
}