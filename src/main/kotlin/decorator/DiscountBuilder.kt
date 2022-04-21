package decorator

import decorator.decorator.TenOrderDiscount
import decorator.decorator.WelcomeDiscount

data class DiscountBuilder(val discountType: DiscountType) {
    var discount: Discount = when(discountType) {
        DiscountType.STUDENT -> StudentDiscount()
        DiscountType.VIP -> VipDiscount()
    }

    fun welcomeDiscount(): DiscountBuilder = apply {
        discount = WelcomeDiscount(discount)
    }

    fun tenOrderDiscount(): DiscountBuilder = apply {
        discount = TenOrderDiscount(discount)
    }
}
