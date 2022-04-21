package decorator

class VipDiscount: Discount {
    companion object {
        const val RATE = 0.05
        const val HISTORY = "VIP 할이"
    }

    override fun amountAfterDiscount(amount: Double): Double {
        return amount * RATE
    }

    override fun history(): String {
        return HISTORY
    }
}