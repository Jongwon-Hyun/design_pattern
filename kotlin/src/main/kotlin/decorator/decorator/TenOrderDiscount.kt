package decorator.decorator

import decorator.Discount

class TenOrderDiscount(private val discount: Discount): Discount {
    companion object {
        const val RATE = 0.02
        const val HISTORY = "10번 주문 할이"
    }

    override fun amountAfterDiscount(amount: Double): Double {
        return discount.amountAfterDiscount(amount) * RATE
    }

    override fun history(): String {
        return "${discount.history()} $HISTORY"
    }
}